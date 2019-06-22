package com.game.paperrockscissors.service;

import com.game.paperrockscissors.type.GameMove;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PrintStream;

@RunWith(SpringRunner.class)
public class PlayServiceTest {


    @Mock
    private PrintStream out;

    @Mock
    private RuleService ruleService;

    @Mock
    private MoveService moveService;

    @InjectMocks
    private PlayService playService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void playGameHumanWinsTest() {
        Mockito.when(moveService.computerPlays())
                .thenReturn(GameMove.PAPER);
        Mockito.when(moveService.humanPlays())
                .thenReturn(GameMove.SCISSORS);

        Mockito.when(ruleService.executeRule(Mockito.any(GameMove.class), Mockito.any(GameMove.class))).thenCallRealMethod();

        playService.playGame();

        Mockito.verify(moveService, Mockito.times(1)).computerPlays();
        Mockito.verify(moveService, Mockito.times(1)).humanPlays();
    }

    @Test
    public void playGameComputerWinsTest() {
        Mockito.when(moveService.computerPlays())
                .thenReturn(GameMove.ROCK);
        Mockito.when(moveService.humanPlays())
                .thenReturn(GameMove.SCISSORS);

        Mockito.when(ruleService.executeRule(Mockito.any(GameMove.class), Mockito.any(GameMove.class)))
                .thenCallRealMethod();

        playService.playGame();

        Mockito.verify(moveService, Mockito.times(1)).computerPlays();
        Mockito.verify(moveService, Mockito.times(1)).humanPlays();
    }

    @Test
    public void playGameDrawTest() {
        Mockito.when(moveService.computerPlays())
                .thenReturn(GameMove.ROCK)
                .thenReturn(GameMove.ROCK);

        Mockito.when(moveService.humanPlays())
                .thenReturn(GameMove.ROCK)
                .thenReturn(GameMove.SCISSORS);

        Mockito.when(ruleService.executeRule(Mockito.any(GameMove.class), Mockito.any(GameMove.class)))
                .thenCallRealMethod();

        playService.playGame();

        Mockito.verify(moveService, Mockito.times(2)).computerPlays();
        Mockito.verify(moveService, Mockito.times(2)).humanPlays();
    }
}
