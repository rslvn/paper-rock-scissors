package com.game.paperrockscissors;

import com.game.paperrockscissors.service.GameExitService;
import com.game.paperrockscissors.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.PrintStream;
import java.util.Scanner;

@SpringBootApplication
public class PaperRockScissorsApplication implements CommandLineRunner {

    @Bean
    public PrintStream out() {
        return System.out;
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Autowired
    private GameService gameService;

    @Autowired
    private GameExitService gameExitService;

    public static void main(String[] args) {
        SpringApplication.run(PaperRockScissorsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        gameService.manageGame();
        gameExitService.forceExit(0);
    }
}
