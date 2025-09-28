package org.coolandfunandnice.matchengine.player.attribute.impl;

import org.coolandfunandnice.matchengine.player.attribute.BasePlayerAttribute;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeKey;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeValue;

public class ShootingAttribute extends BasePlayerAttribute {
    public ShootingAttribute(PlayerAttributeValue value) {
        super(PlayerAttributeKey.SHOOTING, value);
    }
    @Override
    public PlayerAttributeKey getKey() {
        return PlayerAttributeKey.SHOOTING;
    }
}

