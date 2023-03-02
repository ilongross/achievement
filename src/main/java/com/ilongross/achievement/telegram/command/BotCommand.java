package com.ilongross.achievement.telegram.command;

public class BotCommand {

    private final String command;
    private final String name;

    public BotCommand(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public String command() {
        return command;
    }

    public String name() {
        return name;
    }
}
