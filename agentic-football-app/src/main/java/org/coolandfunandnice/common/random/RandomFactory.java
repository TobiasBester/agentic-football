package org.coolandfunandnice.common.random;

import java.security.SecureRandom;

public class RandomFactory {
    private static final RandomFactory INSTANCE = new RandomFactory();

    private final SecureRandom instanceRandom;
    private final SecureRandom timeBasedRandom;

    private RandomFactory() {
        this.instanceRandom = new SecureRandom();
        this.timeBasedRandom = new SecureRandom(Long.toString(System.currentTimeMillis()).getBytes());
    }

    public static RandomFactory getInstance() {
        return INSTANCE;
    }

    public SecureRandom createNewRandom() {
        return new SecureRandom();
    }

    public SecureRandom createNewRandom(byte[] seed) {
        return new SecureRandom(seed);
    }

    public SecureRandom getInstanceRandom() {
        return instanceRandom;
    }

    public SecureRandom getTimeBasedRandom() {
        return timeBasedRandom;
    }
}
