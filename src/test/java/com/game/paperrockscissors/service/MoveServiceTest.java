package com.game.paperrockscissors.service;

import com.game.paperrockscissors.type.GameMove;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@RunWith(SpringRunner.class)
public class MoveServiceTest {

    @Mock
    private PrintStream out;

    private MoveService moveService;

    @Test
    public void humanPlaysTest() {
        String input = String.format("%s%n%s", "any", GameMove.PAPER.getValue());
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        moveService = new MoveService(out, scanner);

        GameMove gameMove = moveService.humanPlays();

        Assert.assertNotNull("gameMove is null", gameMove);
        Assert.assertEquals("gameMove is not paper", gameMove, GameMove.PAPER);
    }

    @Test
    public void computerPlaysTest() {
        Scanner scanner = new Scanner(System.in);
        moveService = new MoveService(out, scanner);


        GameMove gameMove = moveService.computerPlays();
        Assert.assertNotNull("gameMove is null", gameMove);
    }
}
