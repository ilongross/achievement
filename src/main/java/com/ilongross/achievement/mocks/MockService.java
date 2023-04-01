package com.ilongross.achievement.mocks;

import com.ilongross.achievement.dto.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MockService {

    private static Map<Long, PlayerStatisticsDto> playerStatisticsMap = new HashMap<>();
    private static Map<Long, List<GameStatistics>> playerGameStatisticsMap = new HashMap<>();

    {
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

        playerStatisticsMap = statList
                .stream()
                .collect(Collectors.toMap(
                        PlayerStatisticsDto::getId,
                        stat -> stat));

        var gamesList = new ArrayList<GameStatistics>();

        playerStatisticsMap.keySet().forEach(id -> {
            var rand = new Random();
            for(int i = 0; i <= rand.nextInt(20); i++) {
                var game = new GameStatistics();
                game.setPlayerId(id);
                game.setGameSetup(new GameSetupDto());
                game.setWinning(rand.nextBoolean());
                game.setFinished(LocalDateTime.now());
                gamesList.add(game);
            }

            playerGameStatisticsMap.put(id, gamesList);
        });
    }

    public List<PlayerStatisticsDto> getSummaryStatistics() {
        return playerStatisticsMap.values()
                .stream()
                .toList();
    }

    public PlayerSummaryStatisticsDto getPlayerSummaryStatistics(Long id) {
        if(playerStatisticsMap.containsKey(id)) {
            var summaryStat = new PlayerSummaryStatisticsDto();
            summaryStat.setPlayerStatistics(playerStatisticsMap.get(id));
            summaryStat.setGameStatistics(playerGameStatisticsMap.get(id));

            return summaryStat;
        }

        return null;
    }
}
