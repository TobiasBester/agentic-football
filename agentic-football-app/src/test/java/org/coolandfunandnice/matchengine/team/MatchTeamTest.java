package org.coolandfunandnice.matchengine.team;

import org.coolandfunandnice.common.enums.PitchSide;
import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.coolandfunandnice.matchengine.factory.MatchFactoryUtil.createTestPitch;
import static org.coolandfunandnice.matchengine.team.MatchTeam.createMatchTeam;

public class MatchTeamTest {

    @Test
    public void shouldCreatePositionPlayerMap() {
        Pitch standardPitch = createTestPitch();
        final var matchTeam = createMatchTeam(4, 3, 3, PitchSide.L_TO_R, standardPitch);

        Assertions.assertEquals(1, matchTeam.getPositionPlayerMap().get(Position.GOALKEEPER).size());
        Assertions.assertEquals(4, matchTeam.getPositionPlayerMap().get(Position.DEFENDER).size());
        Assertions.assertEquals(3, matchTeam.getPositionPlayerMap().get(Position.MIDFIELDER).size());
        Assertions.assertEquals(3, matchTeam.getPositionPlayerMap().get(Position.FORWARD).size());

        final var matchTeam2 = createMatchTeam(3, 5, 2, PitchSide.R_TO_L, standardPitch);

        Assertions.assertEquals(1, matchTeam2.getPositionPlayerCountMap().get(Position.GOALKEEPER));
        Assertions.assertEquals(3, matchTeam2.getPositionPlayerCountMap().get(Position.DEFENDER));
        Assertions.assertEquals(5, matchTeam2.getPositionPlayerCountMap().get(Position.MIDFIELDER));
        Assertions.assertEquals(2, matchTeam2.getPositionPlayerCountMap().get(Position.FORWARD));
    }

}
