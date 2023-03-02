package com.ilongross.achievement.service;

import com.ilongross.achievement.telegram.command.BotCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelBotService {

    private final LevelService levelService;

    public String result(String input, BotCommand botCommand) {
        return switch (botCommand.command()) {
            case "command1" -> get(input);
            case "command2" -> create();
            case "command3" -> update();
            case "command4" -> delete();
            case "command5" -> structure();
            default -> "empty";
        };
    }

    private String structure() {
        return "structure";
    }

    private String delete() {
        return "delete";
    }

    private String update() {
        return "update";
    }

    private String create() {
        return "create";
    }


    private String get(String incomingMessage) {
        var levelDto = levelService.get(Integer.parseInt(incomingMessage));

        return String.format("Уровень:\nИмя - %s\nНабрано баллов - %s\nНужно баллов для перехода - %s",
                levelDto.getName(),
                levelDto.getScoredPoints(),
                levelDto.getJumpPoints());
    }
}
