package org.coolandfunandnice.matchengine;

import org.coolandfunandnice.matchengine.environment.MatchBall;
import org.coolandfunandnice.matchengine.environment.MatchBallOperator;
import org.coolandfunandnice.matchengine.team.MatchTeam;
import org.coolandfunandnice.matchengine.team.MatchTeamOperator;

/**
 * Container for all match-related objects.
 */
public class Match {

    // 3 types of objects:
    // 1. Info objects: immutable, contain data only, no behavior
    // 2. State objects: mutable, contain data only, no behavior
    // 3. Operator objects: mutable, contain data and behavior, operate on state objects

    private final MatchInfo matchInfo;
    private final MatchBall matchBall;
    private final MatchTeam homeTeam;
    private final MatchTeam awayTeam;
    private final MatchBallOperator ballOperator;
    private final MatchTeamOperator homeTeamOperator;
    private final MatchTeamOperator awayTeamOperator;

    public Match(MatchInfo matchInfo, MatchBall matchBall, MatchTeam homeTeam, MatchTeam awayTeam, MatchBallOperator ballOperator, MatchTeamOperator homeTeamOperator, MatchTeamOperator awayTeamOperator) {
        this.matchInfo = matchInfo;
        this.matchBall = matchBall;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.ballOperator = ballOperator;
        this.homeTeamOperator = homeTeamOperator;
        this.awayTeamOperator = awayTeamOperator;
    }

    public void reset() {
        ballOperator.reset();
        homeTeamOperator.reset();
        awayTeamOperator.reset();
    }

    public void printDetailedMatchState() {
        matchBall.printDetailedEntityPosition(matchInfo.pitch());
    }

    public void printMatchInfo() {
        IO.println("Match setup");

        IO.println("Ball info:");
        IO.println(matchBall.getBall().toString());

        IO.println("Home Team:");
        IO.println(matchInfo.homeTeamInfo().toString());

        IO.println("Away Team:");
        IO.println(matchInfo.awayTeamInfo().toString());

        IO.println(matchInfo.pitch().toString());
    }

}
