package org.coolandfunandnice.common.enums;

import org.coolandfunandnice.common.random.RandomFactory;

public enum Position {
    GOALKEEPER(1),
    DEFENDER(2),
    MIDFIELDER(3),
    FORWARD(4);

    private static final Position[] OUTFIELD_POSITIONS = {DEFENDER, MIDFIELDER, FORWARD};
    private final Integer order;

    Position(Integer order) {
        this.order = order;
    }

    public static Position randomOutfieldPosition() {
        int randomIndex = (int) (RandomFactory.getInstance().createNewRandom().nextDouble() * OUTFIELD_POSITIONS.length);
        return OUTFIELD_POSITIONS[randomIndex];
    }

    public Integer getOrder() {
        return order;
    }
}
