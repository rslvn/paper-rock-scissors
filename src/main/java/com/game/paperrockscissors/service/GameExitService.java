package com.game.paperrockscissors.service;

import org.springframework.stereotype.Service;

/**
 * The service created to kill java process after exit command.
 */
@Service
public class GameExitService {

    /**
     * kill java process by status
     *
     * @param status the status
     */
    public void forceExit(int status) {
        System.exit(status);
    }

}
