package org.coolandfunandnice.matchengine.factory;

import org.coolandfunandnice.matchengine.environment.Goalpost;
import org.coolandfunandnice.matchengine.environment.Pitch;

public class MatchFactoryUtil {

    public static final double PITCH_X_LENGTH = 100;
    public static final double PITCH_Y_WIDTH = 50;

    public static Pitch createTestPitch() {
        final var goalpost = Goalpost.standard();
        return new Pitch(PITCH_X_LENGTH, PITCH_Y_WIDTH, goalpost);
    }

}
