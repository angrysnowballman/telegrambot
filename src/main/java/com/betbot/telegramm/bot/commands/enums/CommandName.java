package com.betbot.telegramm.bot.commands.enums;

import lombok.Getter;

public enum CommandName {
    START("START_COMMAND"),
    CLOSE("CLOSE_COMMAND");


    private final String name;
    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
