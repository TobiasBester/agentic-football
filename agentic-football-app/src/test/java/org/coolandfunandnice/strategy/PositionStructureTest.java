package org.coolandfunandnice.strategy;

import org.coolandfunandnice.common.enums.PitchSide;
import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.common.util.RoundingUtil;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.factory.MatchFactoryUtil;
import org.coolandfunandnice.matchengine.player.MatchPlayer;
import org.coolandfunandnice.strategy.formation.Formation;
import org.coolandfunandnice.strategy.formation.NarrowFlatPositionStructure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.coolandfunandnice.matchengine.team.MatchTeam.createMatchTeam;

public class PositionStructureTest {

    @Test
    public void shouldCheckStartAndEndGoalkeeperPositions() {
        Pitch standardPitch = MatchFactoryUtil.createTestPitch();
        final var startTeam = createMatchTeam(4, 3, 3, PitchSide.L_TO_R, standardPitch);

        final var narrowFlatFormation = new NarrowFlatPositionStructure(standardPitch, startTeam, new Formation(4, 3, 3));
        narrowFlatFormation.apply();

        List<MatchPlayer> keepers = startTeam.getPositionPlayerMap().get(Position.GOALKEEPER);
        Assertions.assertEquals(1, keepers.size());
        MatchPlayer startKeeper = keepers.getFirst();

        assertPlayerPosition(startKeeper, 2.5, 25);

        final var endTeam = createMatchTeam(4, 3, 3, PitchSide.R_TO_L, standardPitch);
        final var narrowFlatFormation2 = new NarrowFlatPositionStructure(standardPitch, endTeam, new Formation(4, 3, 3));
        narrowFlatFormation2.apply();
        MatchPlayer endKeeper = endTeam.getPositionPlayerMap().get(Position.GOALKEEPER).getFirst();

        assertPlayerPosition(endKeeper, 97.5, 25);
    }

    @Test
    public void shouldCheckNarrow433FormationPositions() {
        Pitch standardPitch = MatchFactoryUtil.createTestPitch();
        final var matchTeam = createMatchTeam(4, 3, 3, PitchSide.L_TO_R, standardPitch);

        final var narrowFlatFormation = new NarrowFlatPositionStructure(standardPitch, matchTeam, new Formation(4, 3, 3));
        narrowFlatFormation.apply();

        List<MatchPlayer> defenders = matchTeam.getPositionPlayerMap().get(Position.DEFENDER);
        Assertions.assertEquals(4, defenders.size());
        assertPlayerPosition(defenders.get(0), 15, 12.5);
        assertPlayerPosition(defenders.get(1), 15, 20.83);
        assertPlayerPosition(defenders.get(2), 15, 29.17);
        assertPlayerPosition(defenders.get(3), 15, 37.5);
    }

    @Test
    public void shouldCheckNarrow433FormationPositionsForEndPitchSide() {
        Pitch standardPitch = MatchFactoryUtil.createTestPitch();
        final var matchTeam = createMatchTeam(4, 3, 3, PitchSide.R_TO_L, standardPitch);

        final var narrowFlatFormation = new NarrowFlatPositionStructure(standardPitch, matchTeam, new Formation(4, 3, 3));
        narrowFlatFormation.apply();

        List<MatchPlayer> defenders = matchTeam.getPositionPlayerMap().get(Position.DEFENDER);
        Assertions.assertEquals(4, defenders.size());
        assertPlayerPosition(defenders.get(0), 85, 37.5);
        assertPlayerPosition(defenders.get(1), 85, 29.17);
        assertPlayerPosition(defenders.get(2), 85, 20.83);
        assertPlayerPosition(defenders.get(3), 85, 12.5);
    }

    private void assertPlayerPosition(MatchPlayer player, double expectedX, double expectedY) {
        Assertions.assertEquals(RoundingUtil.toTwoDecimals(expectedX), RoundingUtil.toTwoDecimals(player.getPositionOnPitch().x()));
        Assertions.assertEquals(RoundingUtil.toTwoDecimals(expectedY), RoundingUtil.toTwoDecimals(player.getPositionOnPitch().y()));
    }

}
