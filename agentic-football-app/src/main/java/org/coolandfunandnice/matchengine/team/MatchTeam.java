package org.coolandfunandnice.matchengine.team;

import org.coolandfunandnice.matchengine.MatchInfo;
import org.coolandfunandnice.matchengine.player.MatchPlayer;

import java.util.List;

public record MatchTeam(
        TeamInfo teamInfo,
        List<MatchPlayer> matchPlayers
) {

    public static MatchTeam fromTeamInfo(TeamInfo teamInfo, MatchInfo matchInfo) {
        return new MatchTeam(teamInfo, teamInfo.players().stream()
                .map(playerInfo -> new MatchPlayer(playerInfo, matchInfo.pitch()))
                .toList());
    }

}
