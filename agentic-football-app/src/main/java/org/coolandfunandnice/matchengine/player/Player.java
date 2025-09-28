package org.coolandfunandnice.matchengine.player;

import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeSet;

public record Player(
        String name,
        Position position,
        PlayerAttributeSet playerAttributes
) {
}
