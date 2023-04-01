package com.ilongross.achievement.service;

import com.ilongross.achievement.dto.PlayerStatisticsDto;

import java.util.List;

public interface StatisticsService {

    List<PlayerStatisticsDto> getSummary();

}
