package org.coolandfunandnice.matchengine;

import org.coolandfunandnice.matchengine.environment.Ball;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.team.TeamInfo;

public record MatchInfo(
        TeamInfo homeTeamInfo,
        TeamInfo awayTeamInfo,
        Pitch pitch,
        Ball ball
) {

}
