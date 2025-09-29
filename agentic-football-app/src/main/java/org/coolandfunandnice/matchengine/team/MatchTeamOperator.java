package org.coolandfunandnice.matchengine.team;

import org.coolandfunandnice.matchengine.MatchInfo;
import org.coolandfunandnice.matchengine.environment.MatchBall;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.operators.BasePitchEntityOperator;
import org.coolandfunandnice.matchengine.operators.PitchEntityOperator;
import org.coolandfunandnice.matchengine.player.MatchPlayerOperator;

import java.util.List;
import java.util.Objects;

public final class MatchTeamOperator extends BasePitchEntityOperator
        implements PitchEntityOperator {

    private final MatchTeam matchTeam;
    private final List<MatchPlayerOperator> playerOperators;

    public MatchTeamOperator(MatchBall matchBall, Pitch pitch, MatchTeam matchTeam,
                             List<MatchPlayerOperator> playerOperators) {
        super(matchBall, pitch);
        this.matchTeam = matchTeam;
        this.playerOperators = playerOperators;
    }

    public static MatchTeamOperator fromMatchTeam(MatchTeam matchTeam, MatchBall matchBall, MatchInfo matchInfo) {
        return new MatchTeamOperator(
                matchBall,
                matchInfo.pitch(),
                matchTeam,
                matchTeam.matchPlayers().stream()
                        .map(player -> new MatchPlayerOperator(matchBall, matchInfo.pitch(), player.getPlayerInfo()))
                        .toList()
        );
    }

    public MatchTeam matchTeam() {
        return matchTeam;
    }

    public List<MatchPlayerOperator> playerOperators() {
        return playerOperators;
    }

    @Override
    public void reset() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MatchTeamOperator) obj;
        return Objects.equals(this.matchBall, that.matchBall) &&
                Objects.equals(this.pitch, that.pitch) &&
                Objects.equals(this.matchTeam, that.matchTeam) &&
                Objects.equals(this.playerOperators, that.playerOperators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchBall, pitch, matchTeam, playerOperators);
    }

    @Override
    public String toString() {
        return "MatchTeamOperator[" +
                "matchBall=" + matchBall + ", " +
                "pitch=" + pitch + ", " +
                "matchTeam=" + matchTeam + ", " +
                "playerOperators=" + playerOperators + ']';
    }
}
