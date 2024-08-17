package com.ilongross.achievement.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class GameResultDto implements Serializable {

    private Long playerId;
    private boolean win;
    private int scoreFirst;
    private int scoreSecond;
    private LocalDateTime finished;

}
