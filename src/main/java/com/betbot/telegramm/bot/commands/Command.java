package com.betbot.telegramm.bot.commands;

import com.betbot.telegramm.bot.commands.enums.CommandName;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    boolean canHandle(Update update);
    void handle(Update update);
    CommandName getCommand();

}
