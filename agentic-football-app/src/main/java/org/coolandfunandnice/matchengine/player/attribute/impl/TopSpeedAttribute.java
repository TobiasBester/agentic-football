package org.coolandfunandnice.matchengine.player.attribute.impl;

import org.coolandfunandnice.matchengine.player.attribute.BasePlayerAttribute;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeKey;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeValue;

public class TopSpeedAttribute extends BasePlayerAttribute {

    public TopSpeedAttribute(PlayerAttributeValue value) {
        super(PlayerAttributeKey.TOP_SPEED, value);
    }

    @Override
    public PlayerAttributeKey getKey() {
        return PlayerAttributeKey.TOP_SPEED;
    }
}
