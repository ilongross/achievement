package com.ilongross.achievement.config;

import com.ilongross.achievement.telegram.bot.BotService;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class SpringConfig {

    @SneakyThrows
    @Bean
    public TelegramBotsApi telegramBotsApi(BotService botService) {
        var telegramApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramApi.registerBot(botService);
        return telegramApi;
    }
}
