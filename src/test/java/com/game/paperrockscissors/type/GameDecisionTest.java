package com.game.paperrockscissors.type;

import org.junit.Assert;
import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

import java.util.Optional;

public class GameDecisionTest {

    private static final String PRESENT_MESSAGE = "GameDecision is present";

    @Test
    public void getGameDecisionTest() {
        String value = "2";
        Optional<GameDecision> gameDecisionOptional = GameDecision.getGameDecision(value);

        Assert.assertTrue(gameDecisionOptional.isPresent());
        gameDecisionOptional.ifPresent(gameDecision ->
                Assert.assertEquals("GameDecision value is mismatched", gameDecision.getValue(), value));
    }

    @Test
    public void getGameDecisionAnyValueTest() {
        String value = "Any";
        Optional<GameDecision> gameDecisionOptional = GameDecision.getGameDecision(value);

        Assert.assertFalse(PRESENT_MESSAGE, gameDecisionOptional.isPresent());
    }

    @Test
    public void getGameDecisionNullValueTest() {
        String value = null;
        Optional<GameDecision> gameDecisionOptional = GameDecision.getGameDecision(value);

        Assert.assertFalse(PRESENT_MESSAGE, gameDecisionOptional.isPresent());
    }

    @Test
    public void getGameDecisionEmptyValueTest() {
        String value = "";
        Optional<GameDecision> gameDecisionOptional = GameDecision.getGameDecision(value);

        Assert.assertFalse(PRESENT_MESSAGE, gameDecisionOptional.isPresent());
    }

    @Test
    public void testGameDecisionAsPojo() {
        Assertions.assertPojoMethodsFor(GameDecision.class).testing(Method.GETTER).areWellImplemented();
    }
}
