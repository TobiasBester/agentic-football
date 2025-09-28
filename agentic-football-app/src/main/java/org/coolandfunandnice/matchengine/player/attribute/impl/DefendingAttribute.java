package org.coolandfunandnice.matchengine.player.attribute.impl;

import org.coolandfunandnice.matchengine.player.attribute.BasePlayerAttribute;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeKey;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeValue;

public class DefendingAttribute extends BasePlayerAttribute {
    public DefendingAttribute(PlayerAttributeValue value) {
        super(PlayerAttributeKey.DEFENDING, value);
    }
    @Override
    public PlayerAttributeKey getKey() {
        return PlayerAttributeKey.DEFENDING;
    }
}