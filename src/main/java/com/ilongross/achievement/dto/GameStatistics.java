package com.ilongross.achievement.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class GameStatistics implements Serializable {

    private Long playerId;
    private GameSetupDto gameSetup;
    private boolean isWinning;
    private LocalDateTime finished;

}
