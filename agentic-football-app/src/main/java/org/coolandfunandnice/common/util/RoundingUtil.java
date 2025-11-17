package org.coolandfunandnice.common.util;

public class RoundingUtil {

    public static double toTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
