package com.game.paperrockscissors.service;

import com.game.paperrockscissors.type.GameDecision;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;


/**
 * This service is created to manage games
 */
@Service
public class GameService {

    private PrintStream out;
    private Scanner scanner;
    private PlayService playService;

    public GameService(PrintStream out, Scanner scanner, PlayService playService) {
        this.out = out;
        this.scanner = scanner;
        this.playService = playService;
    }

    /**
     * This method manages new game or exit by player decision
     */
    public void manageGame() {

        while (true) {
            playService.playGame();

            GameDecision gameDecision = newGameOrExitDecision();
            if (gameDecision.equals(GameDecision.EXIT)) {
                break;
            }
        }

        out.println("Destroy the game");
    }

    /**
     * accepts player decision as input. Returns the decision if it is valid
     *
     * @return a game decision
     */
    protected GameDecision newGameOrExitDecision() {
        while (true) {
            out.println();
            for (GameDecision decision : GameDecision.values()) {
                out.println(decision.getComment());
            }

            String option = scanner.nextLine();

            Optional<GameDecision> gameDecisionOptional = GameDecision.getGameDecision(option);

            if (gameDecisionOptional.isPresent()) {
                return gameDecisionOptional.get();
            } else {
                out.println(String.format("Unknown option: %s", option));
            }
        }
    }

}
