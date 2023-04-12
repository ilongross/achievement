package com.ilongross.achievement.telegram.bot;

import com.ilongross.achievement.service.LevelBotService;
import com.ilongross.achievement.telegram.command.CommandRegister;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class BotService extends TelegramLongPollingBot {

    private final LevelBotService levelBotService;
    private final CommandRegister commandRegister;

    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        var incomingMessage = update.getMessage().getText();

//        var resultText = levelBotService.resultById(incomingMessage);

        var message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
//        message.setText(resultText);

        execute(message);
    }
}
