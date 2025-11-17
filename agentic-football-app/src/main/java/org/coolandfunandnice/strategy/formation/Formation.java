package org.coolandfunandnice.strategy.formation;

public record Formation(
        int numDefenders,
        int numMidfielders,
        int numForwards
) {
    public String formationId() {
        return String.format("%s-%s-%s", numDefenders, numMidfielders, numForwards);
    }
}
