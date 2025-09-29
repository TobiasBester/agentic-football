package org.coolandfunandnice.matchengine.team.factory;

import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.player.PlayerInfo;
import org.coolandfunandnice.matchengine.player.factory.PlayerFactory;
import org.coolandfunandnice.matchengine.team.TeamInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TeamFactory {

    public static TeamInfo createRandomTeamInfo(int numPlayersPerTeam) {
        final var players = createRandomPlayerInfos(numPlayersPerTeam);
        return new TeamInfo(
                generateRandomTeamName(),
                generateRandomCoachName(),
                players
        );
    }

    private static List<PlayerInfo> createRandomPlayerInfos(int numPlayers) {
        final var players = new ArrayList<PlayerInfo>();
        players.add(PlayerFactory.createRandomPlayer(Position.GOALKEEPER));

        if (numPlayers > 1) {
            players.addAll(IntStream.range(1, numPlayers)
                    .mapToObj(i -> PlayerFactory.createRandomPlayer(Position.randomOutfieldPosition()))
                    .toList());
        }

        return players;
    }

    private static String generateRandomTeamName() {
        return "Team_" + Math.round(Math.random() * 10000);
    }

    private static String generateRandomCoachName() {
        return "Coach_" + Math.round(Math.random() * 10000);
    }

}
