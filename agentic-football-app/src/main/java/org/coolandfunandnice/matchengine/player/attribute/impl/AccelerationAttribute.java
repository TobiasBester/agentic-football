package org.coolandfunandnice.matchengine.player.attribute.impl;

import org.coolandfunandnice.matchengine.player.attribute.BasePlayerAttribute;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeKey;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeValue;

public class AccelerationAttribute extends BasePlayerAttribute {

    public AccelerationAttribute(PlayerAttributeValue value) {
        super(PlayerAttributeKey.ACCELERATION, value);
    }

    @Override
    public PlayerAttributeKey getKey() {
        return PlayerAttributeKey.ACCELERATION;
    }
}
