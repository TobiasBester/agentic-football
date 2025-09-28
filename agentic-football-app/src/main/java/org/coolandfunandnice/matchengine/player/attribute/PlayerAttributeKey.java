package org.coolandfunandnice.matchengine.player.attribute;

import org.coolandfunandnice.matchengine.player.attribute.impl.*;

import java.util.function.Function;

public enum PlayerAttributeKey {
    TOP_SPEED(TopSpeedAttribute::new),
    ACCELERATION(AccelerationAttribute::new),
    STAMINA(StaminaAttribute::new),
    PASSING(PassingAttribute::new),
    DRIBBLING(DribblingAttribute::new),
    SHOOTING(ShootingAttribute::new),
    DEFENDING(DefendingAttribute::new);

    public PlayerAttribute create(PlayerAttributeValue value) {
        return creatorMethod.apply(value);
    }

    private final Function<PlayerAttributeValue, PlayerAttribute> creatorMethod;

    PlayerAttributeKey(Function<PlayerAttributeValue, PlayerAttribute> creatorMethod) {
        this.creatorMethod = creatorMethod;
    }
}
