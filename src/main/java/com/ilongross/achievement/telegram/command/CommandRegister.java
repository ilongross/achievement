package com.ilongross.achievement.telegram.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CommandRegister {

    @Value("${bot.commands}")
    private Map<String, String> commands;

    public Map<String, BotCommand> map() {
        return commands.keySet().stream()
                .map(key -> new BotCommand(key, commands.get(key)))
                .collect(Collectors.toMap(
                        BotCommand::command,
                        command -> command));
    }

    public boolean isCommand(String command) {
        return commands.containsKey(command);
    }

    public BotCommand get(String command) {
        return map().get(command);
    }

}
