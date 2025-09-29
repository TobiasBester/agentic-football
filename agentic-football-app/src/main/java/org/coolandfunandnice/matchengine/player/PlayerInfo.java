package org.coolandfunandnice.matchengine.player;

import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeSet;

public record PlayerInfo(
        String name,
        Position position,
        PlayerAttributeSet playerAttributes
) implements Comparable<PlayerInfo> {

    @Override
    public int compareTo(PlayerInfo o) {
        return this.position().getOrder().compareTo(o.position().getOrder());
    }
}
