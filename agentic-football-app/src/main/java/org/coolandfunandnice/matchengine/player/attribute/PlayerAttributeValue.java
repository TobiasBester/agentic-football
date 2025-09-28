package org.coolandfunandnice.matchengine.player.attribute;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public record PlayerAttributeValue(
        Double value,

        /*
          Normalized value between 0 and 1
         */
        Double normalizedValue
) {
    public Long normalizedValueInt() {
        return Math.round(normalizedValue * 100.0);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(java.util.Locale.UK));
        return "{value=" +
                df.format(value) +
                ", norm=" + normalizedValueInt() +
                '}';
    }
}
