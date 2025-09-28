package org.coolandfunandnice.matchengine;

import org.coolandfunandnice.matchengine.environment.MatchBallOperator;

public record Match(MatchSetup matchSetup, MatchBallOperator ballOperator) {

    public static Match createDefaultMatch(MatchSetup setup) {
        return new Match(setup, MatchBallOperator.fromMatchSetup(setup));
    }

    public void resetMatch() {
        ballOperator.reset();
    }

    public void printDetailedMatchState() {
        ballOperator.printDetailedBallPosition();
    }

    public void printMatchSetup() {
        IO.println("Match setup");

        IO.println("Home Players:");
        matchSetup.homePlayers().forEach(player -> IO.println(player.toString()));

        IO.println("Away Players:");
        matchSetup.awayPlayers().forEach(player -> IO.println(player.toString()));

        IO.println("Pitch:");
        IO.println(matchSetup.pitch().toString());
    }

}
