package com.game.paperrockscissors.service;

import com.game.paperrockscissors.type.GameMove;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

/**
 * This service is created to manage player moves
 */
@Service
public class MoveService {

    private PrintStream out;
    private Scanner scanner;

    public MoveService(PrintStream out, Scanner scanner) {
        this.out = out;
        this.scanner = scanner;
    }

    /**
     * This method manages human player moves
     *
     * @return a game move
     */
    public GameMove humanPlays() {
        while (true) {
            out.println();
            out.println("Your turn");
            for (GameMove move : GameMove.values()) {
                out.println(move.getComment());
            }

            String moveValue = scanner.nextLine();

            Optional<GameMove> gameMoveOptional = GameMove.getGameMove(moveValue);

            if (gameMoveOptional.isPresent()) {
                return gameMoveOptional.get();
            } else {
                out.println(String.format("Unknown move: %s", moveValue));
            }
        }
    }

    /**
     * This method manages computer's moves
     *
     * @return a game move
     */
    public GameMove computerPlays() {
        return GameMove.values()[new Random().nextInt(GameMove.values().length)];
    }
}
