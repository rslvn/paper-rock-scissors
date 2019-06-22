package com.game.paperrockscissors;

import com.game.paperrockscissors.service.GameExitService;
import com.game.paperrockscissors.service.GameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperRockScissorsApplicationTests {

    @MockBean
    private GameService gameService;

    @MockBean
    private GameExitService gameExitService;

    @InjectMocks
    private PaperRockScissorsApplication paperRockScissorsApplication;

    @Autowired
    private Scanner scanner;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void contextLoads() {
        Assert.notNull(scanner, "scanner not inialized");
    }

}
