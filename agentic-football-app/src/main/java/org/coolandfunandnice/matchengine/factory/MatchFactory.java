package org.coolandfunandnice.matchengine.factory;

import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.Match;
import org.coolandfunandnice.matchengine.MatchSetup;
import org.coolandfunandnice.matchengine.player.Player;
import org.coolandfunandnice.matchengine.player.factory.PlayerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MatchFactory {

    public static Match createDefaultMatch(int numPlayersPerTeam) {
        if (numPlayersPerTeam < 1) {
            throw new IllegalArgumentException("Number of players per team must be at least 1");
        }

        var matchSetup = switch (numPlayersPerTeam) {
            case 1 -> createOneOnOneDefaultMatchSetup();
            default -> createMultiPlayerDefaultMatchSetup(numPlayersPerTeam);
        };
        return Match.createDefaultMatch(matchSetup);
    }

    private static MatchSetup createOneOnOneDefaultMatchSetup() {
        return new MatchSetup(
                List.of(
                        PlayerFactory.createRandomPlayer(Position.GOALKEEPER)
                ),
                List.of(
                        PlayerFactory.createRandomPlayer(Position.GOALKEEPER)
                )
        );
    }

    private static MatchSetup createMultiPlayerDefaultMatchSetup(int numPlayersPerTeam) {
        return new MatchSetup(
                createDefaultPlayers(numPlayersPerTeam),
                createDefaultPlayers(numPlayersPerTeam)
        );
    }

    private static List<Player> createDefaultPlayers(int numPlayers) {
        final var players = new ArrayList<Player>();
        players.add(PlayerFactory.createRandomPlayer(Position.GOALKEEPER));

        players.addAll(IntStream.range(1, numPlayers)
                .mapToObj(i -> PlayerFactory.createRandomPlayer(Position.randomOutfieldPosition()))
                .toList());

        return players;
    }

}
