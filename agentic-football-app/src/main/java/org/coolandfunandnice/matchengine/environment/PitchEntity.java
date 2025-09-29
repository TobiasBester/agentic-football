package org.coolandfunandnice.matchengine.environment;

import org.coolandfunandnice.common.enums.Coordinate;

public interface PitchEntity {
    Coordinate getPitchEntityCoordinate();

    void setPitchEntityCoordinate(Coordinate coordinate);

    default void move(double deltaX, double deltaY) {
        Coordinate current = getPitchEntityCoordinate();
        if (current != null) {
            double newX = current.x() + deltaX;
            double newY = current.y() + deltaY;
            setPitchEntityCoordinate(new Coordinate(newX, newY));
        }
    }

    default String getPitchRelativePositionString(Pitch pitch) {
        final var entityCoord = getPitchEntityCoordinate();
        final var ballInsidePitch = pitch.isInsidePitch(entityCoord);
        final var ballInsideStartGoal = pitch.isInsideStartGoal(entityCoord);
        final var ballInsideEndGoal = pitch.isInsideEndGoal(entityCoord);
        final var ballDistanceToStartGoal = pitch.distanceToStartGoal(entityCoord);
        final var ballDistanceToEndGoal = pitch.distanceToEndGoal(entityCoord);
        return String.format("Ball Position: (x=%.2f, y=%.2f), InsidePitch=%b, InsideStartGoal=%b, InsideEndGoal=%b, DistanceToStartGoal=%.2f, DistanceToEndGoal=%.2f",
                entityCoord.x(), entityCoord.y(),
                ballInsidePitch, ballInsideStartGoal, ballInsideEndGoal,
                ballDistanceToStartGoal, ballDistanceToEndGoal);
    }

    default void printDetailedBallPosition(Pitch pitch) {
        IO.println(getPitchRelativePositionString(pitch));
    }
}
