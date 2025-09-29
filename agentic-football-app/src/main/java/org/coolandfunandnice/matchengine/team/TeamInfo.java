package org.coolandfunandnice.matchengine.team;

import org.coolandfunandnice.matchengine.player.PlayerInfo;

import java.util.List;

public record TeamInfo(
        String name,
        String coachName,
        List<PlayerInfo> players
) {
}
