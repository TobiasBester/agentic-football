package org.coolandfunandnice.common.enums;

public enum Position {
    GOALKEEPER,
    DEFENDER,
    MIDFIELDER,
    FORWARD;

    private static final Position[] OUTFIELD_POSITIONS = {DEFENDER, MIDFIELDER, FORWARD};

    public static Position randomOutfieldPosition() {
        int randomIndex = (int) (Math.random() * OUTFIELD_POSITIONS.length);
        return OUTFIELD_POSITIONS[randomIndex];
    }
}
