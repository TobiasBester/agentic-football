package org.coolandfunandnice.matchengine.environment;

public record Goalpost(double yWidthMeters, double zHeightMeters, double postWidthMeters) {

    public static Goalpost standard() {
        return new Goalpost(7.32, 2.44, 0.12);
    }

}
