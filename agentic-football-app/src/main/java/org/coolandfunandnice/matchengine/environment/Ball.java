package org.coolandfunandnice.matchengine.environment;

public record Ball(double xWidthMeters, double yWidthMeters, double zHeightMeters) {
    public static Ball standard() {
        return Ball.create(0.7);
    }

    private static Ball create(double xWidthMeters) {
        return new Ball(xWidthMeters, xWidthMeters, xWidthMeters);
    }
}
