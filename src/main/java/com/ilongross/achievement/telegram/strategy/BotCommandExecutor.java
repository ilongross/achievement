package com.ilongross.achievement.telegram.strategy;

public interface BotCommandExecutor {

    BotCommandType getType();

    String commandName();

    String getResult(Long object);

}
