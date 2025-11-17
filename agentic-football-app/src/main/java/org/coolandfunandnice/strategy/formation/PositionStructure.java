package org.coolandfunandnice.strategy.formation;

import org.coolandfunandnice.common.Coordinate;
import org.coolandfunandnice.common.enums.PitchSide;
import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.player.MatchPlayer;
import org.coolandfunandnice.matchengine.team.MatchTeam;

import java.util.Collections;
import java.util.List;

/**
 * Encapsulates how any formation is structured space-wise
 */
public abstract class PositionStructure {

    protected final Pitch pitch;
    protected final MatchTeam matchTeam;
    protected final Formation formation;

    protected PositionStructure(Pitch pitch, MatchTeam matchTeam, Formation formation) {
        this.pitch = pitch;
        this.matchTeam = matchTeam;
        this.formation = formation;
    }

    public void apply() {
        final var positionPlayerMap = matchTeam.getPositionPlayerMap();

        setGoalkeeper(
                positionPlayerMap.getOrDefault(Position.GOALKEEPER, Collections.emptyList())
                        .stream().findFirst().orElse(null)
        );
        setDefenders(positionPlayerMap.getOrDefault(Position.DEFENDER, Collections.emptyList()));
        setMidfielders(positionPlayerMap.getOrDefault(Position.MIDFIELDER, Collections.emptyList()));
        setForwards(positionPlayerMap.getOrDefault(Position.FORWARD, Collections.emptyList()));
    }

    public PitchSide pitchSide() {
        return matchTeam.pitchSide();
    }

    protected double pitchXFromHalfwayLine(double xFromHalfwayLine) {
        return pitchSide() == PitchSide.L_TO_R
                ? pitch.getCenter().x() - xFromHalfwayLine
                : pitch.getCenter().x() + xFromHalfwayLine;
    }

    protected double pitchPercentageXFromHalfwayLine(double percentageXFromHalfwayLine) {
        double pitchHalfLength = pitch.getCenter().x();
        double xFromHalfwayLine = pitchHalfLength * percentageXFromHalfwayLine;
        return pitchXFromHalfwayLine(xFromHalfwayLine);
    }

    protected double pitchPercentageYFromCenter(double percentageYFromCenter) {
        double yFromCenter = pitch.getCenter().y() * percentageYFromCenter;
        return pitch.getCenter().y() + yFromCenter;
    }

    Coordinate getGoalkeeperPosition() {
        return new Coordinate(
                pitchPercentageXFromHalfwayLine(0.95),
                pitch.getCenter().y()
        );
    }

    void setGoalkeeper(MatchPlayer matchPlayer) {
        if (matchPlayer == null) {
            return;
        }

        final var coordinate = getGoalkeeperPosition();
        matchPlayer.setPositionOnPitch(coordinate);
    }

    abstract void setDefenders(List<MatchPlayer> players);

    abstract void setMidfielders(List<MatchPlayer> players);

    abstract void setForwards(List<MatchPlayer> players);

}
