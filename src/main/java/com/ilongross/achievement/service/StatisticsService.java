package com.ilongross.achievement.service;

import com.ilongross.achievement.dto.PlayerStatisticsDto;
import com.ilongross.achievement.dto.PlayerSummaryStatisticsDto;

import java.util.List;

public interface StatisticsService {

    List<PlayerStatisticsDto> getSummary();

    PlayerSummaryStatisticsDto getPlayerSummaryStatistics(Long id);
}
