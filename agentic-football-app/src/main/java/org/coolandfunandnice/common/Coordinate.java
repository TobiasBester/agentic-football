package org.coolandfunandnice.common;

public record Coordinate(double x, double y) {
    public static final Coordinate ZERO = new Coordinate(0.0, 0.0);

    public double distanceTo(Coordinate other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
