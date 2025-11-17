package org.coolandfunandnice.matchengine.team.factory;

import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.common.random.RandomFactory;
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

    public static TeamInfo createRandomTeamInfo(int numDefenders, int numMidfielders, int numForwards) {
        final var players = createRandomPlayerInfos(numDefenders, numMidfielders, numForwards);
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

    private static List<PlayerInfo> createRandomPlayerInfos(int numGoalkeepers,
                                                            int numDefenders,
                                                            int numMidfielders,
                                                            int numForwards) {
        final var players = new ArrayList<PlayerInfo>();

        players.addAll(IntStream.range(0, numGoalkeepers)
                .mapToObj(i -> PlayerFactory.createRandomPlayer(Position.GOALKEEPER))
                .toList());
        players.addAll(IntStream.range(0, numDefenders)
                .mapToObj(i -> PlayerFactory.createRandomPlayer(Position.DEFENDER))
                .toList());
        players.addAll(IntStream.range(0, numMidfielders)
                .mapToObj(i -> PlayerFactory.createRandomPlayer(Position.MIDFIELDER))
                .toList());
        players.addAll(IntStream.range(0, numForwards)
                .mapToObj(i -> PlayerFactory.createRandomPlayer(Position.FORWARD))
                .toList());

        return players;
    }

    private static List<PlayerInfo> createRandomPlayerInfos(int numDefenders,
                                                            int numMidfielders,
                                                            int numForwards) {
        return createRandomPlayerInfos(1, numDefenders, numMidfielders, numForwards);
    }

    private static String generateRandomTeamName() {
        return "Team_" + Math.round(RandomFactory.getInstance().createNewRandom().nextDouble() * 10000);
    }

    private static String generateRandomCoachName() {
        return "Coach_" + Math.round(RandomFactory.getInstance().createNewRandom().nextDouble() * 10000);
    }

}
