package com.game.paperrockscissors.service;

import com.game.paperrockscissors.type.GameMove;
import com.game.paperrockscissors.type.WinningStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class RuleServiceTest {

    private static final String HUMAN_NOT_WIN_MESSAGE = "Human does not win";

    @InjectMocks
    private RuleService ruleService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void humanWinsByPaperTest() {

        GameMove humanMove = GameMove.PAPER;
        GameMove computerMove = GameMove.ROCK;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.HUMAN);
    }

    @Test
    public void humanWinsByRockTest() {

        GameMove humanMove = GameMove.ROCK;
        GameMove computerMove = GameMove.SCISSORS;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.HUMAN);
    }

    @Test
    public void humanWinsByScissorsTest() {

        GameMove humanMove = GameMove.SCISSORS;
        GameMove computerMove = GameMove.PAPER;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.HUMAN);
    }


    @Test
    public void computerWinsByPaperTest() {

        GameMove humanMove = GameMove.ROCK;
        GameMove computerMove = GameMove.PAPER;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.COMPUTER);
    }

    @Test
    public void computerWinsByRockTest() {

        GameMove humanMove = GameMove.SCISSORS;
        GameMove computerMove = GameMove.ROCK;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.COMPUTER);
    }

    @Test
    public void computerWinsByScissorsTest() {

        GameMove humanMove = GameMove.PAPER;
        GameMove computerMove = GameMove.SCISSORS;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.COMPUTER);
    }


    @Test
    public void drawByScissorsTest() {

        GameMove humanMove = GameMove.SCISSORS;
        GameMove computerMove = GameMove.SCISSORS;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.DRAW);
    }

    @Test
    public void drawByRockTest() {

        GameMove humanMove = GameMove.ROCK;
        GameMove computerMove = GameMove.ROCK;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.DRAW);
    }

    @Test
    public void drawByPaperTest() {

        GameMove humanMove = GameMove.PAPER;
        GameMove computerMove = GameMove.PAPER;

        WinningStatus winningStatus = ruleService.executeRule(humanMove, computerMove);

        Assert.assertEquals(HUMAN_NOT_WIN_MESSAGE, winningStatus, WinningStatus.DRAW);
    }
}
