package com.ilongross.achievement.telegram.bot;

import com.ilongross.achievement.service.LevelBotService;
import com.ilongross.achievement.service.LevelService;
import com.ilongross.achievement.telegram.command.CommandRegister;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class BotService extends TelegramLongPollingBot {

    private final LevelBotService levelBotService;
    private final CommandRegister commandRegister;

    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    public BotService(LevelBotService levelBotService, CommandRegister commandRegister) {
        this.levelBotService = levelBotService;
        this.commandRegister = commandRegister;
    }

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
        try {
            var incomingMessage = update.getMessage().getText();

            var resultText = "";

            var isCommand = commandRegister.isCommand(incomingMessage);
            if (isCommand) {
                resultText = levelBotService.result(incomingMessage, commandRegister.get(incomingMessage));
            }

            var message = new SendMessage();
            message.setChatId(update.getMessage().getChatId());
            message.setText(resultText);

            execute(message);
        } catch (TelegramApiException e) {
            var error = new SendMessage();
            error.setText(e.getMessage());
            execute(error);
        }
    }
}
