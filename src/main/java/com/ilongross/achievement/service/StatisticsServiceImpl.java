package com.ilongross.achievement.service;

import com.ilongross.achievement.dto.PlayerStatisticsDto;
import com.ilongross.achievement.dto.PlayerSummaryStatisticsDto;
import com.ilongross.achievement.mocks.MockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final MockService mockService;

    @Override
    public List<PlayerStatisticsDto> getSummary() {
        return mockService.getSummaryStatistics();
    }

    @Override
    public PlayerSummaryStatisticsDto getPlayerSummaryStatistics(Long id) {
        return mockService.getPlayerSummaryStatistics(id);
    }
}
