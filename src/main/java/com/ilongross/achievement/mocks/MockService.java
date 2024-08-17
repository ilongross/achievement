package com.ilongross.achievement.mocks;

import com.ilongross.achievement.dto.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MockService {

    private static Map<Long, PlayerStatisticsDto> playerStatisticsMap = new HashMap<>();
    private static final Map<Long, List<GameResultDto>> gameResultsMap = new HashMap<>();

    @PostConstruct
    public void init() {
        var achievementNames = List.of(
                "Лучший бомбардир сезона",
                "Победитель сезона",
                "Рекордный рейтинг в сезоне",
                "Длиннейшая серия побед",
                "Весь сезон на 1-ом месте");

        var achievementDescriptions = List.of(
                "800 голов",
                "3 квартал 2023",
                "1923",
                "32",
                "4 квартал 2022");

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
            var index = rand.nextInt(4);
            achievement.setName(achievementNames.get(index));
            achievement.setDescription(achievementDescriptions.get(index));
            playerStat.setAchievements(List.of(achievement));

            statList.add(playerStat);
        });

        playerStatisticsMap = statList
                .stream()
                .collect(Collectors.toMap(
                        PlayerStatisticsDto::getId,
                        stat -> stat));

        var gamesList = new ArrayList<GameResultDto>();

        playerStatisticsMap.keySet().forEach(id -> {
            var rand = new Random();
            for (int i = 0; i <= rand.nextInt(20); i++) {
                var game = new GameResultDto();
                game.setPlayerId(id);
                game.setWin(rand.nextBoolean());
                game.setScoreFirst(rand.nextInt(8));
                game.setScoreSecond(rand.nextInt(8));
                game.setFinished(LocalDateTime.now());

                gamesList.add(game);
            }

            gameResultsMap.put(id, gamesList);
        });
    }

    public List<PlayerStatisticsDto> getSummaryStatistics() {
        return playerStatisticsMap.values()
                .stream()
                .sorted(Comparator
                        .comparing(PlayerStatisticsDto::getRate)
                        .reversed())
                .toList();
    }

    public PlayerSummaryStatisticsDto getPlayerSummaryStatistics(Long id) {
        if (playerStatisticsMap.containsKey(id)) {
            var summaryStat = new PlayerSummaryStatisticsDto();
            summaryStat.setPlayerStatistics(playerStatisticsMap.get(id));
            summaryStat.setGameStatistics(gameResultsMap.get(id));

            return summaryStat;
        }

        return null;
    }

    public GameResultDto getGameResult(Long id) {
        return new GameResultDto();
    }
}
