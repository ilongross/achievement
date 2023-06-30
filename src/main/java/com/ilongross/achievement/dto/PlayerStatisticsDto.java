package com.ilongross.achievement.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PlayerStatisticsDto implements Serializable {

    private Long id;
    private String name;
    private int rate;
    private List<AchievementDto> achievements;

}
