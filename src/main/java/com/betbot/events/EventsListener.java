package com.betbot.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.io.Serializable;

@Component
public class EventsListener {
    private final TelegramClient telegramClient;
    private final MessageTrackerService messageTrackerService;

    public EventsListener(TelegramClient telegramClient, MessageTrackerService messageTrackerService) {
        this.telegramClient = telegramClient;
        this.messageTrackerService = messageTrackerService;
    }

    @EventListener
    public void on(MessageEvent event) throws TelegramApiException {
        BotApiMethod<? extends Serializable> message = event.getMessage();
        Serializable result = telegramClient.execute(message);

        if (result instanceof Message) {
            Message sentMessage = (Message) result;
            if (sentMessage.getMessageId() != null) {
                messageTrackerService.saveLastMessage(sentMessage.getChatId(), sentMessage.getMessageId());
            }
        }
    }
}
