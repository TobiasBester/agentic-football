package org.coolandfunandnice.matchengine.player.factory;

import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.common.random.RandomFactory;
import org.coolandfunandnice.matchengine.player.PlayerInfo;
import org.coolandfunandnice.matchengine.player.attribute.factory.PlayerAttributeFactory;

public class PlayerFactory {

    public static PlayerInfo createRandomPlayer(Position position) {
        final var playerAttributeSet = PlayerAttributeFactory.createRandomAttributeSet();
        return new PlayerInfo(generateRandomName(), position, playerAttributeSet);
    }

    private static String generateRandomName() {
        return "Player_" + Math.round(RandomFactory.getInstance().createNewRandom().nextDouble() * 10000);
    }

}
