package org.coolandfunandnice.matchengine.player.attribute.impl;

import org.coolandfunandnice.matchengine.player.attribute.BasePlayerAttribute;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeKey;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeValue;

public class PassingAttribute extends BasePlayerAttribute {
    public PassingAttribute(PlayerAttributeValue value) {
        super(PlayerAttributeKey.PASSING, value);
    }
    @Override
    public PlayerAttributeKey getKey() {
        return PlayerAttributeKey.PASSING;
    }
}

