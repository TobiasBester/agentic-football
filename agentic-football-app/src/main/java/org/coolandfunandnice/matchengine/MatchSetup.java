package org.coolandfunandnice.matchengine;

import org.coolandfunandnice.matchengine.player.Player;

import java.util.List;

public record MatchSetup(
        List<Player> homePlayers,
        List<Player> awayPlayers
) {

}
