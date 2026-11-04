package com.betbot.telegramm.bot.commands.impl.command;

import com.betbot.factory.Constants;
import com.betbot.telegramm.bot.commands.Command;
import com.betbot.telegramm.bot.commands.dto.EventView;
import com.betbot.telegramm.bot.commands.enums.CommandName;
import com.betbot.telegramm.bot.commands.service.BetFacadeService;
import com.betbot.telegramm.bot.commands.util.CommandKeyboards;
import com.betbot.telegramm.bot.commands.util.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShowEventsCommand implements Command {

    private static final int PAGE_SIZE = 5;

    private final TelegramClient telegramClient;
    private final BetFacadeService betFacade;

    @Override
    public boolean canHandle(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) return false;
        String text = update.getMessage().getText().trim();
        return text.equals(CommandName.SHOW_EVENTS.getCommandText())
                || text.equals(Constants.BTN_EVENTS);
    }

    @Override
    public void handle(Update update) {
        Long chatId = update.getMessage().getChatId();
        sendEvents(chatId, 0);
    }

    /** Публичный метод — вызывается и при пагинации из callback-команды */
    public void sendEvents(Long chatId, int page) {
        List<EventView> events = betFacade.getActiveEvents(page, PAGE_SIZE);
        long total = betFacade.countActiveEvents();
        boolean hasNext = (long) (page + 1) * PAGE_SIZE < total;

        if (events.isEmpty()) {
            MessageUtils.reply(telegramClient, chatId, "Пока нет активных событий.");
            return;
        }

        MessageUtils.reply(telegramClient, chatId, Constants.EVENTS_PROMPT,
                CommandKeyboards.eventsKeyboard(events, page, hasNext));
    }

    @Override
    public CommandName getCommandName() {
        return CommandName.SHOW_EVENTS;
    }


}
