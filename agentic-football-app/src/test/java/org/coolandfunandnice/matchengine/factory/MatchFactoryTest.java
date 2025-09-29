package org.coolandfunandnice.matchengine.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.coolandfunandnice.matchengine.Match;

public class MatchFactoryTest {

    @Test
    void createRandomMatch_withOnePlayerPerTeam_returnsNonNullMatchAndDoesNotThrowOnBasicOps() {
        Match match = MatchFactory.createRandomMatch(1);
        Assertions.assertNotNull(match, "Match should not be null");

        // Smoke-test: ensure public methods don't throw
        match.printMatchInfo();
        match.printDetailedMatchState();
        match.reset();
    }

    @Test
    void createRandomMatch_throwsOnZeroPlayers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MatchFactory.createRandomMatch(0));
    }
}
