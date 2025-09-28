package org.coolandfunandnice.matchengine;

import org.coolandfunandnice.matchengine.player.Player;

import java.util.List;

public record Match(List<Player> homePlayers, List<Player> awayPlayers) {

    public static Match createDefaultMatch(MatchSetup setup) {
        return new Match(setup.homePlayers(), setup.awayPlayers());
    }

    public void printMatchSetup() {
        IO.println("Match setup");

        IO.println("Home Players:");
        homePlayers.forEach(player -> IO.println(player.toString()));

        IO.println("Away Players:");
        awayPlayers.forEach(player -> IO.println(player.toString()));
    }

}
