package com.ilongross.achievement.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PlayerSummaryStatisticsDto implements Serializable {

    private PlayerStatisticsDto playerStatistics;
    private List<GameStatistics> gameStatistics;

}
