package com.ilongross.achievement.controller;

import com.ilongross.achievement.dto.PlayerStatisticsDto;
import com.ilongross.achievement.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics/")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/summary")
    public List<PlayerStatisticsDto> getSummary() {
        return statisticsService.getSummary();
    }

}
