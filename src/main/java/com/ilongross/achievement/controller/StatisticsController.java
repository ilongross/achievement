package com.ilongross.achievement.controller;

import com.ilongross.achievement.dto.PlayerStatisticsDto;
import com.ilongross.achievement.dto.PlayerSummaryStatisticsDto;
import com.ilongross.achievement.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics/")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/summary")
    public List<PlayerStatisticsDto> getSummary() {
        return statisticsService.getSummary();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public PlayerSummaryStatisticsDto getPlayerSummaryStatistics(@PathVariable Long id) {
        return statisticsService.getPlayerSummaryStatistics(id);
    }

}
