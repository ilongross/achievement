package com.ilongross.achievement.mocks;

import com.ilongross.achievement.dto.AchievementDto;
import com.ilongross.achievement.dto.PlayerStatisticsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MockService {

    public List<PlayerStatisticsDto> getSummaryStatistics() {
        var achievementNames = List.of(
                "Лучший бомбардир сезона - 800 голов",
                "Победитель сезона - 3 квартал 2023",
                "Рекордный рейтинг в сезоне - 1923",
                "Длиннейшая серия побед - 32",
                "Весь сезон на 1-ом месте - 4 квартал 2022");
        var playerNames = List.of(
                "Андрей",
                "Илья",
                "Юрий",
                "Александр");

        var statList = new ArrayList<PlayerStatisticsDto>();
        playerNames.forEach(name -> {
            var rand = new Random();
            var playerStat = new PlayerStatisticsDto();
            playerStat.setId(rand.nextLong(1000L));
            playerStat.setName(name);
            playerStat.setRate(rand.nextInt(2000));

            var achievement = new AchievementDto();
            achievement.setName(achievementNames.get(rand.nextInt(4)));
            playerStat.setAchievements(List.of(achievement));

            statList.add(playerStat);
        });

        return statList;
    }

}
