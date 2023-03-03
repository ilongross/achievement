package com.ilongross.achievement.telegram.command;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "bot")
public class CommandRegister {

    private Map<String, String> commands;

    public Map<String, BotCommand> map() {
        return commands.keySet().stream()
                .map(key -> new BotCommand(key, commands.get(key)))
                .collect(Collectors.toMap(
                        BotCommand::command,
                        command -> command));
    }

    public boolean isCommand(String command) {
        return command.startsWith("/") && commands.containsKey(command.replaceFirst("/", ""));
    }

    public BotCommand get(String command) {
        return map().get(command.replaceFirst("/", ""));
    }

}
