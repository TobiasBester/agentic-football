package org.coolandfunandnice.matchengine.player;

import org.coolandfunandnice.matchengine.environment.MatchBall;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.operators.BasePitchEntityOperator;
import org.coolandfunandnice.matchengine.operators.PitchEntityOperator;

import java.util.Objects;

public final class MatchPlayerOperator extends BasePitchEntityOperator
        implements PitchEntityOperator {
    private final PlayerInfo playerInfo;

    public MatchPlayerOperator(MatchBall matchBall, Pitch pitch, PlayerInfo playerInfo) {
        super(matchBall, pitch);
        this.playerInfo = Objects.requireNonNull(playerInfo);
    }

    public PlayerInfo playerInfo() {
        return playerInfo;
    }

    @Override
    public void reset() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MatchPlayerOperator) obj;
        return Objects.equals(this.matchBall, that.matchBall) &&
                Objects.equals(this.pitch, that.pitch) &&
                Objects.equals(this.playerInfo, that.playerInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchBall, pitch, playerInfo);
    }

    @Override
    public String toString() {
        return "MatchPlayerOperator[" +
                "matchBall=" + matchBall + ", " +
                "pitch=" + pitch + ", " +
                "playerInfo=" + playerInfo + ']';
    }
}
