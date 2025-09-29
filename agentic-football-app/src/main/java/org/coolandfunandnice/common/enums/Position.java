package org.coolandfunandnice.common.enums;

import org.coolandfunandnice.common.random.RandomFactory;

public enum Position {
    GOALKEEPER,
    DEFENDER,
    MIDFIELDER,
    FORWARD;

    private static final Position[] OUTFIELD_POSITIONS = {DEFENDER, MIDFIELDER, FORWARD};

    public static Position randomOutfieldPosition() {
        int randomIndex = (int) (RandomFactory.getInstance().createNewRandom().nextDouble() * OUTFIELD_POSITIONS.length);
        return OUTFIELD_POSITIONS[randomIndex];
    }
}
