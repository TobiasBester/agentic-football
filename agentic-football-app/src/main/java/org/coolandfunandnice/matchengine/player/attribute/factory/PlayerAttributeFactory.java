package org.coolandfunandnice.matchengine.player.attribute.factory;

import org.coolandfunandnice.common.random.RandomFactory;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttribute;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeKey;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeSet;
import org.coolandfunandnice.matchengine.player.attribute.PlayerAttributeValue;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PlayerAttributeFactory {

    public static PlayerAttributeSet createDefaultAttributeSet() {
        return createAttributeSet(PlayerAttributeFactory::getDefaultValue);
    }

    private static PlayerAttributeValue getDefaultValue() {
        return new PlayerAttributeValue(50d, 0.5);
    }

    public static PlayerAttributeSet createRandomAttributeSet() {
        return createAttributeSet(PlayerAttributeFactory::getRandomValue);
    }

    private static PlayerAttributeValue getRandomValue() {
        final var random = RandomFactory.getInstance().createNewRandom();
        final var value = random.nextDouble() * 100d;
        final var twoDecimalValue = Math.round(value * 100d) / 100d;
        final var normalizedValue = twoDecimalValue / 100d;

        return new PlayerAttributeValue(twoDecimalValue, normalizedValue);
    }

    private static PlayerAttributeSet createAttributeSet(Supplier<PlayerAttributeValue> valueGenerator) {
        Map<PlayerAttributeKey, PlayerAttribute> playerAttributeMap = Arrays.stream(PlayerAttributeKey.values()).map(
                playerAttributeKey -> playerAttributeKey.create(valueGenerator.get())
        ).collect(Collectors.toMap(
                PlayerAttribute::getKey,
                playerAttribute -> playerAttribute
        ));
        return new PlayerAttributeSet(playerAttributeMap);
    }

}
