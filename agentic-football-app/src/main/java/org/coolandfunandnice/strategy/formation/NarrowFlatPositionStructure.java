package org.coolandfunandnice.strategy.formation;

import org.coolandfunandnice.common.enums.PitchSide;
import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.player.MatchPlayer;
import org.coolandfunandnice.matchengine.team.MatchTeam;

import java.util.List;

public class NarrowFlatPositionStructure extends PositionStructure {

    private static final double DEFENDER_Y_SPREAD = 0.50;
    private static final double MIDFIELDER_Y_SPREAD = 0.50;
    private static final double FORWARD_Y_SPREAD = 0.50;

    public NarrowFlatPositionStructure(Pitch pitch, MatchTeam matchTeam, Formation formation) {
        super(pitch, matchTeam, formation);
    }

    @Override
    void setDefenders(List<MatchPlayer> matchPlayers) {
        setPlayers(matchPlayers, pitchPercentageXFromHalfwayLine(0.70), DEFENDER_Y_SPREAD, Position.DEFENDER);
    }

    @Override
    void setMidfielders(List<MatchPlayer> matchPlayers) {
        setPlayers(matchPlayers, pitchPercentageXFromHalfwayLine(0.45), MIDFIELDER_Y_SPREAD, Position.MIDFIELDER);
    }

    @Override
    void setForwards(List<MatchPlayer> matchPlayers) {
        setPlayers(matchPlayers, pitchPercentageXFromHalfwayLine(0.20), FORWARD_Y_SPREAD, Position.FORWARD);
    }

    private void setPlayers(List<MatchPlayer> players, double xPos, double ySpread, Position position) {
        int numPlayers = (int) players.stream()
                .filter(p -> p.getPlayerInfo().position().equals(position))
                .count();
        if (numPlayers == 0) {
            return;
        }

        double yIncrement = (pitch.widthMeters() * ySpread) / (numPlayers - 1);
        double startY = (pitch.widthMeters() - (yIncrement * (numPlayers - 1))) / 2;
        for (int i = 0; i < numPlayers; i++) {
            MatchPlayer player = players.get(pitchSide().equals(PitchSide.L_TO_R) ? i : numPlayers - i - 1);
            player.setPositionOnPitch(xPos, startY + (i * yIncrement));
        }
    }
}
