package org.coolandfunandnice.matchengine.environment;

import org.coolandfunandnice.common.enums.Coordinate;
import org.coolandfunandnice.matchengine.MatchSetup;

public record MatchBallOperator(MatchBall matchBall, Pitch pitch) {

    public static MatchBallOperator fromMatchSetup(MatchSetup matchSetup) {
        return new MatchBallOperator(new MatchBall(matchSetup.ball()), matchSetup.pitch());
    }

    public void reset() {
        matchBall.setCoordinate(pitch.getCenter());
    }

    public void move(double deltaX, double deltaY) {
        double newX = getBallCoordinate().x() + deltaX;
        double newY = getBallCoordinate().y() + deltaY;
        matchBall.setCoordinate(new Coordinate(newX, newY));
    }

    private Coordinate getBallCoordinate() {
        return matchBall.getCoordinate();
    }

    public String getDetailedBallPositionString() {
        final var coordinate = getBallCoordinate();
        final var ballInsidePitch = pitch.ballIsInsidePitch(matchBall);
        final var ballInsideStartGoal = pitch.ballIsInsideStartGoal(matchBall);
        final var ballInsideEndGoal = pitch.ballIsInsideEndGoal(matchBall);
        final var ballDistanceToStartGoal = pitch.distanceToStartGoal(matchBall);
        final var ballDistanceToEndGoal = pitch.distanceToEndGoal(matchBall);
        return String.format("Ball Position: (x=%.2f, y=%.2f), InsidePitch=%b, InsideStartGoal=%b, InsideEndGoal=%b, DistanceToStartGoal=%.2f, DistanceToEndGoal=%.2f",
                coordinate.x(), coordinate.y(),
                ballInsidePitch, ballInsideStartGoal, ballInsideEndGoal,
                ballDistanceToStartGoal, ballDistanceToEndGoal);
    }

    public void printDetailedBallPosition() {
        IO.println(getDetailedBallPositionString());
    }

}
