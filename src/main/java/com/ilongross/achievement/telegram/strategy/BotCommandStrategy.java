package com.ilongross.achievement.telegram.strategy;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class BotCommandStrategy {

    private final Map<String, BotCommandExecutor> commandExecutorsMap;

    public BotCommandStrategy(List<BotCommandExecutor> commandExecutors) {
        this.commandExecutorsMap = commandExecutors
                .stream()
                .collect(Collectors.toMap(
                        BotCommandExecutor::commandName,
                        command -> command));
    }

    public String getStringResult(String command) {
        return commandExecutorsMap.get(command).getResult(1L);
    }

}
