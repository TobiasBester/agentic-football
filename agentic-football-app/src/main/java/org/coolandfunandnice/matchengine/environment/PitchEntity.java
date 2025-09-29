package org.coolandfunandnice.matchengine.environment;

import org.coolandfunandnice.common.enums.Coordinate;

public interface PitchEntity {
    Coordinate getPitchEntityCoordinate();

    void setPitchEntityCoordinate(Coordinate coordinate);

    String getLabel();

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
        if (entityCoord == null) {
            return String.format("%s: (unplaced)", getLabel());
        }
        final var entityInsidePitch = pitch.isInsidePitch(entityCoord);
        final var entityInsideStartGoal = pitch.isInsideStartGoal(entityCoord);
        final var entityInsideEndGoal = pitch.isInsideEndGoal(entityCoord);
        final var entityDistanceToStartGoal = pitch.distanceToStartGoal(entityCoord);
        final var entityDistanceToEndGoal = pitch.distanceToEndGoal(entityCoord);
        return String.format("%s: (x=%.2f, y=%.2f), InsidePitch=%b, InsideStartGoal=%b, InsideEndGoal=%b, DistanceToStartGoal=%.2f, DistanceToEndGoal=%.2f",
                getLabel(),
                entityCoord.x(), entityCoord.y(),
                entityInsidePitch, entityInsideStartGoal, entityInsideEndGoal,
                entityDistanceToStartGoal, entityDistanceToEndGoal);
    }

    default void printDetailedEntityPosition(Pitch pitch) {
        IO.println(getPitchRelativePositionString(pitch));
    }
}
