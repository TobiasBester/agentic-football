package org.coolandfunandnice.matchengine.team;

import org.coolandfunandnice.matchengine.MatchInfo;
import org.coolandfunandnice.matchengine.environment.MatchBall;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.player.MatchPlayerOperator;

import java.util.List;

public record MatchTeamOperator(MatchBall matchBall, Pitch pitch, MatchTeam matchTeam,
                                List<MatchPlayerOperator> playerOperators) {
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
}
