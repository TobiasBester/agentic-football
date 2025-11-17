package org.coolandfunandnice.matchengine.team;

import org.coolandfunandnice.common.enums.HomeOrAway;
import org.coolandfunandnice.common.enums.PitchSide;
import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.MatchInfo;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.player.MatchPlayer;
import org.coolandfunandnice.matchengine.team.factory.TeamFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Container for team information and its players during a match.
 */
public record MatchTeam(
        TeamInfo teamInfo,
        HomeOrAway homeOrAway,
        PitchSide pitchSide,
        List<MatchPlayer> matchPlayers
) {

    public static MatchTeam fromTeamInfo(TeamInfo teamInfo, HomeOrAway homeOrAway, PitchSide pitchSide, MatchInfo matchInfo) {
        return new MatchTeam(teamInfo, homeOrAway, pitchSide, teamInfo.players().stream()
                .map(playerInfo -> new MatchPlayer(playerInfo, matchInfo.pitch()))
                .toList());
    }

    public Map<Position, List<MatchPlayer>> getPositionPlayerMap() {
        return matchPlayers.stream().collect(Collectors.groupingBy(
                matchPlayer -> matchPlayer.getPlayerInfo().position()
        ));
    }

    public Map<Position, Integer> getPositionPlayerCountMap() {
        return matchPlayers.stream().collect(Collectors.toMap(
                matchPlayer -> matchPlayer.getPlayerInfo().position(),
                p -> 1,
                Integer::sum
        ));
    }

    public static MatchTeam createMatchTeam(int numDefs, int numMids, int numFwds, PitchSide pitchSide, Pitch pitch) {
        final var teamInfo = TeamFactory.createRandomTeamInfo(numDefs, numMids, numFwds);
        // TODO: Separate TeamInfo concept from formation since a team can switch formations mid-game
        List<MatchPlayer> matchPlayers = teamInfo.orderedPlayers().stream()
                .map(playerInfo -> new MatchPlayer(playerInfo, pitch))
                .toList();

        return new MatchTeam(
                teamInfo,
                HomeOrAway.HOME,
                pitchSide,
                matchPlayers
        );
    }

}
