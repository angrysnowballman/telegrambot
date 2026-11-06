package com.betbot.telegramm.bot.commands.enums;

import lombok.Getter;

    @Getter
    public enum CommandName {
        START("START_COMMAND", "/start"),
        CLOSE("CLOSE_COMMAND", "/close"),

        SHOW_EVENTS("SHOW_EVENTS_COMMAND", "/events"),
        PLACE_BET("PLACE_BET_COMMAND", "/bet"),
        MY_BETS("MY_BETS_COMMAND", "/mybets");

        private final String name;
        private final String commandText;

        CommandName(String name, String commandText) {
            this.name = name;
            this.commandText = commandText;
        }
    }

