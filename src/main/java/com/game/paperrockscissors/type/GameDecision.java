package com.game.paperrockscissors.type;

import lombok.Getter;

import java.util.Optional;

/**
 * This enum created to keep game decision types
 */
@Getter
public enum GameDecision {

    NEW("1", "Press 1 for new game"),
    EXIT("2", "Press 2 to exit");

    private String value;
    private String comment;

    GameDecision(String value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    /**
     * Returns a GameDecision optional by value
     *
     * @param value the value
     * @return a GameDecision
     */
    public static Optional<GameDecision> getGameDecision(String value) {
        for (GameDecision gameDecision : GameDecision.values()) {
            if (gameDecision.value.equals(value)) {
                return Optional.of(gameDecision);
            }
        }
        return Optional.empty();
    }
}
