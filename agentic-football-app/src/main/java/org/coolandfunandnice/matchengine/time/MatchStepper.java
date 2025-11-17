package org.coolandfunandnice.matchengine.time;

/**
 * Represents the progress of a Match in terms of percentage and time progression
 */
public class MatchStepper {

    private static final double DEFAULT_START = 0;
    private static final double DEFAULT_END = 100;
    private static final double DEFAULT_STEP_SIZE = 1;
    // TODO: Add concept of represented time
    private final double start;
    private double stepNumber;
    private final double end;
    private final double stepSize;

    private MatchStepper(double start, double end, double stepNumber, double stepSize) {
        this.start = start;
        this.end = end;
        this.stepNumber = stepNumber;
        this.stepSize = stepSize;
    }

    public static MatchStepper createDefault() {
        return new MatchStepper(
                DEFAULT_START,
                DEFAULT_END,
                DEFAULT_START,
                DEFAULT_STEP_SIZE
        );
    }

    public static MatchStepper create(double numSteps, double stepSize) {
        return new MatchStepper(
                DEFAULT_START,
                numSteps,
                DEFAULT_START,
                stepSize
        );
    }

    public boolean hasNext() {
        return stepNumber < end;
    }

    public void step() {
        if (!hasNext()) {
            throw new IllegalStateException("No more steps available");
        }
        stepNumber += stepSize;
    }

    public double getStart() {
        return start;
    }

    public double getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(double stepNumber) {
        this.stepNumber = stepNumber;
    }

    public double getEnd() {
        return end;
    }

    public double getStepSize() {
        return stepSize;
    }
}
