package org.coolandfunandnice.matchengine.player.attribute.impl;

import org.coolandfunandnice.matchengine.player.attribute.BasePlayerAttribute;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeKey;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeValue;

public class DribblingAttribute extends BasePlayerAttribute {
    public DribblingAttribute(PlayerAttributeValue value) {
        super(PlayerAttributeKey.DRIBBLING, value);
    }
    @Override
    public PlayerAttributeKey getKey() {
        return PlayerAttributeKey.DRIBBLING;
    }
}

