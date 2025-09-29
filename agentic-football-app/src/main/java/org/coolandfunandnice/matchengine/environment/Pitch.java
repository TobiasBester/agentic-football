package org.coolandfunandnice.matchengine.environment;

import org.coolandfunandnice.common.enums.Coordinate;

public record Pitch(double lengthMeters, double widthMeters, Goalpost goalpost) {
    public static Pitch standard() {
        return new Pitch(105, 68, Goalpost.standard());
    }

    public Coordinate getStartGoalpostLeftCoord() {
        return new Coordinate(0, widthMeters + (goalpost.xWidthMeters() / 2));
    }

    public Coordinate getStartGoalpostRightCoord() {
        return new Coordinate(0, widthMeters - (goalpost.xWidthMeters() / 2));
    }

    public Coordinate getStartGoalpostCenterCoord() {
        return new Coordinate(0, widthMeters / 2);
    }

    public Coordinate getEndGoalpostLeftCoord() {
        return new Coordinate(lengthMeters, widthMeters + (goalpost.xWidthMeters() / 2));
    }

    public Coordinate getEndGoalpostRightCoord() {
        return new Coordinate(lengthMeters, widthMeters - (goalpost.xWidthMeters() / 2));
    }

    public Coordinate getEndGoalpostCenterCoord() {
        return new Coordinate(lengthMeters, widthMeters / 2);
    }

    public Coordinate getCenter() {
        return new Coordinate(lengthMeters / 2, widthMeters / 2);
    }

    public boolean isInsidePitch(Coordinate coordinate) {
        return coordinate.x() >= 0 && coordinate.x() <= lengthMeters
                && coordinate.y() >= 0 && coordinate.y() <= widthMeters;
    }

    public boolean isInsideStartGoal(Coordinate coordinate) {
        return coordinate.x() < 0 &&
                (coordinate.y() > getStartGoalpostRightCoord().y() && coordinate.y() < getStartGoalpostLeftCoord().y());
    }

    public boolean isInsideEndGoal(Coordinate coordinate) {
        return coordinate.x() > lengthMeters &&
                (coordinate.y() > getEndGoalpostLeftCoord().y() && coordinate.y() < getEndGoalpostRightCoord().y());
    }

    public double distanceFromCenter(Coordinate coordinate) {
        return coordinate.distanceTo(getCenter());
    }

    public double distanceToStartGoal(Coordinate coordinate) {
        final var startGoalCenter = getStartGoalpostCenterCoord();
        return coordinate.distanceTo(startGoalCenter);
    }

    public double distanceToEndGoal(Coordinate coordinate) {
        final var endGoalCenter = getEndGoalpostCenterCoord();
        return coordinate.distanceTo(endGoalCenter);
    }

    @Override
    public String toString() {
        return "Pitch{" +
                "lengthMeters=" + lengthMeters +
                ", widthMeters=" + widthMeters +
                ", goalpost=" + goalpost +
                ", startGoalCenter=" + getStartGoalpostCenterCoord() +
                ", endGoalCenter=" + getEndGoalpostCenterCoord() +
                '}';
    }
}
