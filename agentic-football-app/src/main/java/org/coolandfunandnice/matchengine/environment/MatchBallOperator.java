package org.coolandfunandnice.matchengine.environment;

import org.coolandfunandnice.matchengine.operators.BasePitchEntityOperator;
import org.coolandfunandnice.matchengine.operators.PitchEntityOperator;

public class MatchBallOperator extends BasePitchEntityOperator
        implements PitchEntityOperator {

    public MatchBallOperator(MatchBall matchBall, Pitch pitch) {
        super(matchBall, pitch);
    }

    public void reset() {
        matchBall.setCoordinate(pitch.getCenter());
    }

}
