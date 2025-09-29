package org.coolandfunandnice.matchengine.operators;

import org.coolandfunandnice.matchengine.environment.MatchBall;
import org.coolandfunandnice.matchengine.environment.Pitch;

public abstract class BasePitchEntityOperator {
    protected final MatchBall matchBall;
    protected final Pitch pitch;

    protected BasePitchEntityOperator(MatchBall matchBall, Pitch pitch) {
        this.matchBall = matchBall;
        this.pitch = pitch;
    }

}
