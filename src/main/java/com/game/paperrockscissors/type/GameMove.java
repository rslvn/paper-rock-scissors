package com.game.paperrockscissors.type;

import lombok.Getter;

import java.util.Optional;

/**
 * This enum created to keep game move types
 */
@Getter
public enum GameMove {
    PAPER("1", "Press 1 for Paper"),
    ROCK("2", "Press 2 for Rock"),
    SCISSORS("3", "Press 3 for Scissors");

    private String value;
    private String comment;

    GameMove(String value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    /**
     * Returns a GameMove optional by value
     *
     * @param value the value
     * @return a GameMove
     */
    public static Optional<GameMove> getGameMove(String value) {
        for (GameMove gameMove : GameMove.values()) {
            if (gameMove.value.equals(value)) {
                return Optional.of(gameMove);
            }
        }
        return Optional.empty();
    }
}
