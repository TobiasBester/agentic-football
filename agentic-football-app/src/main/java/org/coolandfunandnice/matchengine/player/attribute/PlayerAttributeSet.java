package org.coolandfunandnice.matchengine.player.attribute;

import java.util.Map;

public record PlayerAttributeSet(
        Map<PlayerAttributeKey, PlayerAttribute> attributes
) {

    @Override
    public String toString() {
        return attributes.values().stream().map(
                attribute -> attribute.getKey() + "=" + attribute.getValue()
        ).reduce((a, b) -> a + ", " + b).orElse("");
    }
}
