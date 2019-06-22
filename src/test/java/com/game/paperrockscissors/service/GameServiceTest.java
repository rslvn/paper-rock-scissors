package com.game.paperrockscissors.service;

import com.game.paperrockscissors.type.GameDecision;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@RunWith(SpringRunner.class)
public class GameServiceTest {
    @Mock
    private PrintStream out;

    @Mock
    private PlayService playService;

    private GameService gameService;

    @Test
    public void manageGameTest() {
        String input = String.format("%s%n%s",GameDecision.NEW.getValue(),GameDecision.EXIT.getValue()) ;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        gameService = new GameService(out,scanner, playService);
        gameService.manageGame();

        Mockito.verify(playService, Mockito.times(2)).playGame();
    }


    @Test
    public void newGameOrExitDecisionTest() {

        String input = GameDecision.EXIT.getValue();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        gameService = new GameService(out,scanner, playService);

        GameDecision gameDecision = gameService.newGameOrExitDecision();

        Assert.assertEquals("", GameDecision.EXIT, gameDecision);

    }

    @Test
    public void newGameOrExitDecisionUnknownTest() {
        String input = String.format("%s%n%s","any",GameDecision.EXIT.getValue()) ;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        gameService = new GameService(out,scanner, playService);

        GameDecision gameDecision = gameService.newGameOrExitDecision();

        Assert.assertEquals("", GameDecision.EXIT, gameDecision);

    }
}
