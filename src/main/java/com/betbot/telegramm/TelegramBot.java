package com.betbot.telegramm;

import com.betbot.telegramm.bot.commands.CommandHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class TelegramBot implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer, MessageConsumer {
    private final CommandHandler commandHandler;

    private final String botToken;

    public TelegramBot(CommandHandler handler, @Value("${Telegram.bot.token}") String botToken) {
        this.commandHandler = handler;
        this.botToken = botToken;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this;
    }

    @Override
    public void consume(Update update) {
        this.commandHandler.handle(update);
    }
}