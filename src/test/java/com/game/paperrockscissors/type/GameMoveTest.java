package com.game.paperrockscissors.type;

import org.junit.Assert;
import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

import java.util.Optional;

public class GameMoveTest {

    private static final String PRESENT_MESSAGE = "GameMove is present";

    @Test
    public void getGameMoveTest() {
        String value = "2";
        Optional<GameMove> gameMoveOptional = GameMove.getGameMove(value);

        Assert.assertTrue("GameMove is not present", gameMoveOptional.isPresent());
        gameMoveOptional.ifPresent(gameMove ->
                Assert.assertEquals("GameMove value is mismatched", gameMove.getValue(), value));
    }

    @Test
    public void getGameMoveAnyValueTest() {
        String value = "Any";
        Optional<GameMove> gameMoveOptional = GameMove.getGameMove(value);

        Assert.assertFalse(PRESENT_MESSAGE, gameMoveOptional.isPresent());
    }

    @Test
    public void getGameMoveNullValueTest() {
        String value = null;
        Optional<GameMove> gameMoveOptional = GameMove.getGameMove(value);

        Assert.assertFalse(PRESENT_MESSAGE, gameMoveOptional.isPresent());
    }

    @Test
    public void getGameMoveEmptyValueTest() {
        String value = "";
        Optional<GameMove> gameMoveOptional = GameMove.getGameMove(value);

        Assert.assertFalse(PRESENT_MESSAGE, gameMoveOptional.isPresent());
    }

    @Test
    public void testGameMoveAsPojo() {
        Assertions.assertPojoMethodsFor(GameMove.class).testing(Method.GETTER).areWellImplemented();
    }
}
