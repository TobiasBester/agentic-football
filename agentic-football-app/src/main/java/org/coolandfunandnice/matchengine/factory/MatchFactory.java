package org.coolandfunandnice.matchengine.factory;

import org.coolandfunandnice.common.enums.HomeOrAway;
import org.coolandfunandnice.common.enums.PitchSide;
import org.coolandfunandnice.matchengine.Match;
import org.coolandfunandnice.matchengine.MatchInfo;
import org.coolandfunandnice.matchengine.environment.Ball;
import org.coolandfunandnice.matchengine.environment.MatchBall;
import org.coolandfunandnice.matchengine.environment.MatchBallOperator;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.team.MatchTeam;
import org.coolandfunandnice.matchengine.team.MatchTeamOperator;
import org.coolandfunandnice.matchengine.team.factory.TeamFactory;

public class MatchFactory {

    public static Match createMatch(MatchInfo matchInfo) {
        final var pitch = matchInfo.pitch();
        final var matchBall = new MatchBall(matchInfo.ball());
        final var homeTeam = MatchTeam.fromTeamInfo(matchInfo.homeTeamInfo(), HomeOrAway.HOME, PitchSide.L_TO_R, matchInfo);
        final var awayTeam = MatchTeam.fromTeamInfo(matchInfo.awayTeamInfo(), HomeOrAway.AWAY, PitchSide.R_TO_L, matchInfo);
        final var ballOperator = new MatchBallOperator(matchBall, pitch);
        final var homeTeamOperator = MatchTeamOperator.fromMatchTeam(homeTeam, matchBall, matchInfo);
        final var awayTeamOperator = MatchTeamOperator.fromMatchTeam(awayTeam, matchBall, matchInfo);
        return new Match(matchInfo, matchBall, homeTeam, awayTeam, ballOperator, homeTeamOperator, awayTeamOperator);
    }

    public static Match createRandomMatch(int numPlayersPerTeam) {
        if (numPlayersPerTeam < 1) {
            throw new IllegalArgumentException("Number of players per team must be at least 1");
        }

        final var matchInfo = createRandomMatchInfo(numPlayersPerTeam);
        return createMatch(matchInfo);
    }

    public static Match createRandom5v5Match() {
        return createRandomMatch(5);
    }

    private static MatchInfo createRandomMatchInfo(int numPlayersPerTeam) {
        return new MatchInfo(
                numPlayersPerTeam,
                TeamFactory.createRandomTeamInfo(numPlayersPerTeam),
                TeamFactory.createRandomTeamInfo(numPlayersPerTeam),
                Pitch.standard(),
                Ball.standard()
        );
    }

}
