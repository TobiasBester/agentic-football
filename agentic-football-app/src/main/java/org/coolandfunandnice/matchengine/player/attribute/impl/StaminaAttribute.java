package org.coolandfunandnice.matchengine.player.attribute.impl;

import org.coolandfunandnice.matchengine.player.attribute.BasePlayerAttribute;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeKey;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeValue;

public class StaminaAttribute extends BasePlayerAttribute {
    public StaminaAttribute(PlayerAttributeValue value) {
        super(PlayerAttributeKey.STAMINA, value);
    }
    @Override
    public PlayerAttributeKey getKey() {
        return PlayerAttributeKey.STAMINA;
    }
}
