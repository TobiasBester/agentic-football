package org.coolandfunandnice.matchengine.player.attribute;

public abstract class BasePlayerAttribute
        implements PlayerAttribute {

    private final PlayerAttributeKey key;
    private final PlayerAttributeValue value;

    public BasePlayerAttribute(PlayerAttributeKey key, PlayerAttributeValue value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public PlayerAttributeKey getKey() {
        return key;
    }

    @Override
    public PlayerAttributeValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BasePlayerAttribute{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
