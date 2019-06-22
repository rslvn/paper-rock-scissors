package com.game.paperrockscissors.service;

import com.game.paperrockscissors.type.GameMove;
import com.game.paperrockscissors.type.WinningStatus;
import org.springframework.stereotype.Service;

/**
 * This service is created to execute game rules
 */
@Service
public class RuleService {

    public WinningStatus executeRule(GameMove human, GameMove computer) {
        if (human.equals(computer)) {
            return WinningStatus.DRAW;
        }

        switch (human) {
            case PAPER:
                return computer.equals(GameMove.ROCK) ?
                        WinningStatus.HUMAN :
                        WinningStatus.COMPUTER;
            case ROCK:
                return computer.equals(GameMove.SCISSORS) ?
                        WinningStatus.HUMAN :
                        WinningStatus.COMPUTER;
            default:
                return computer.equals(GameMove.PAPER) ?
                        WinningStatus.HUMAN :
                        WinningStatus.COMPUTER;
        }
    }
}
