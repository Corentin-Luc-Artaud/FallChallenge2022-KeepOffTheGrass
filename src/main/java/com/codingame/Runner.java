package com.codingame;

import java.io.PrintStream;

import com.codingame.gameengine.runner.MultiplayerGameRunner;
import com.codingame.gameengine.runner.simulate.GameResult;

public class Runner {
    public static void main(String[] args) {
        if (args.length < 5) {
            throw new RuntimeException("need two players to play this game\n runner <cmd for player1> <player1 name> <cmd for player2> <player2 name> <seed>");
        }

        PrintStream out = System.out;

        MultiplayerGameRunner gameRunner = new MultiplayerGameRunner();
        gameRunner.setSeed(Long.parseLong(args[4]));
        gameRunner.addAgent(args[0], args[1]);
        gameRunner.addAgent(args[2], args[3]);

        GameResult result = gameRunner.simulate();

        if (result.scores.get(0) > result.scores.get(1)) {
            System.out.println(args[1]);
            System.exit(0);
            return;
        }
        out.println(args[3]);
        System.exit(0);
        return;
    }
}
