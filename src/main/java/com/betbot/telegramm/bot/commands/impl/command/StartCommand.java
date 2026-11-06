package com.betbot.telegramm.bot.commands.impl.command;

import com.betbot.telegramm.bot.commands.Command;
import com.betbot.telegramm.bot.commands.enums.CommandName;
import com.betbot.telegramm.bot.util.language.LocalizationServise;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand implements Command {

    private final ApplicationEventPublisher eventPublisher;
    private final LocalizationServise localizationServise;
//    private final KeyBoardService keyBoardService;


    public StartCommand(ApplicationEventPublisher eventPublisher, LocalizationServise localizationServise) {
        this.eventPublisher = eventPublisher;
        this.localizationServise = localizationServise;
    }

    @Override
    public boolean canHandle(Update update) {
        return false;
    }

    @Override
    public void handle(Update update) {

    }

    @Override
    public CommandName getCommand() {
        return null;
    }
}
