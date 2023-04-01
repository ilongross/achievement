package com.ilongross.achievement.service;

import com.ilongross.achievement.telegram.command.BotCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelBotService {

    private final LevelService levelService;
    private final IndexService indexService;
    private final CounterService counterService;

    public String resultByCommand(String input, BotCommand botCommand) {
        return switch (botCommand.command()) {
            case "command1" -> get(input);
            case "command2" -> create();
            case "command3" -> update();
            case "command4" -> delete();
            case "command5" -> structure();
            default -> "empty";
        };
    }

    public String resultById(String input) {
        return get(input);
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
        var index = indexService.defineIndex(levelDto);
        var structureSize = counterService.structureSize(levelDto);

        return String.format("Уровень: %d из %d\nНазвание - %s\nБаллы - %d\nДо следующего - %d",
                index,
                structureSize,
                levelDto.getName(),
                levelDto.getScoredPoints(),
                levelDto.getJumpPoints());
    }
}
