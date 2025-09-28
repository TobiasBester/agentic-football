package org.coolandfunandnice;

import org.coolandfunandnice.matchengine.Match;
import org.coolandfunandnice.matchengine.factory.MatchFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println("Hello and welcome to Agentic Football!");

        Match defaultMatch = MatchFactory.createDefaultMatch(1);
        defaultMatch.printMatchSetup();

        defaultMatch.resetMatch();
        defaultMatch.printDetailedMatchState();
    }
}
