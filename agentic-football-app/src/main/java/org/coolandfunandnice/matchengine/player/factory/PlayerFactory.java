package org.coolandfunandnice.matchengine.player.factory;

import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.player.Player;
import org.coolandfunandnice.matchengine.player.attribute.factory.PlayerAttributeFactory;

public class PlayerFactory {

    public static Player createRandomPlayer(Position position) {
        final var playerAttributeSet = PlayerAttributeFactory.createRandomAttributeSet();
        return new Player(generateRandomName(), position, playerAttributeSet);
    }

    private static String generateRandomName() {
        return "Player_" + Math.round(Math.random() * 10000);
    }

}
