package com.game.paperrockscissors.service;

import com.game.paperrockscissors.type.GameMove;
import com.game.paperrockscissors.type.WinningStatus;
import org.springframework.stereotype.Service;

import java.io.PrintStream;

/**
 * This service is created to manage to play the games
 */
@Service
public class PlayService {

    private PrintStream out;
    private RuleService ruleService;
    private MoveService moveService;

    public PlayService(PrintStream out, RuleService ruleService, MoveService moveService) {
        this.out = out;
        this.ruleService = ruleService;
        this.moveService = moveService;
    }

    /**
     * Game main. This method manages moves and decides next move or finishing the game
     */
    public void playGame() {
        out.println("A new game is started");
        while (true) {
            GameMove playerMove = moveService.humanPlays();
            out.println(String.format("Your move: %s", playerMove));

            GameMove computerMove = moveService.computerPlays();
            out.println(String.format("Computer's move: %s", computerMove));

            WinningStatus winningStatus = ruleService.executeRule(playerMove, computerMove);
            printWinningStatus(winningStatus);

            if (!winningStatus.equals(WinningStatus.DRAW)) {
                break;
            }
        }
    }

    /**
     * Prints winning status after the moves
     *
     * @param winningStatus the winning status
     */
    private void printWinningStatus(WinningStatus winningStatus) {
        switch (winningStatus) {
            case HUMAN:
                out.println("You won!");
                break;
            case COMPUTER:
                out.println("Computer won!");
                break;
            default:
                out.println("No one won. Again");
        }
    }
}
