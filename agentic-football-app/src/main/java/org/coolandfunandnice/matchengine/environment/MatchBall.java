package org.coolandfunandnice.matchengine.environment;

import org.coolandfunandnice.common.Coordinate;

public class MatchBall implements PitchEntity {
    private final Ball ball;
    private Coordinate coordinate = Coordinate.ZERO;

    public MatchBall(Ball ball) {
        this.ball = ball;
    }

    public static MatchBall createDefault() {
        return new MatchBall(Ball.standard());
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Ball getBall() {
        return ball;
    }

    @Override
    public Coordinate getPitchEntityCoordinate() {
        return coordinate;
    }

    @Override
    public void setPitchEntityCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String getLabel() {
        return "MatchBall";
    }
}
