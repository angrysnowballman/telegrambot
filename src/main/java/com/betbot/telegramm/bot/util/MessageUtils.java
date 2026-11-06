package com.betbot.telegramm.bot.util;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Slf4j
public final class MessageUtils {

    // Приватный конструктор, чтобы никто не мог сделать new MessageUtils()
    private MessageUtils() {}

    // Отправка просто текста
    public static void reply(TelegramClient client, Long chatId, String text) {
        reply(client, chatId, text, null);
    }

    // Отправка текста с клавиатурой (кнопками)
    public static void reply(TelegramClient client, Long chatId, String text, InlineKeyboardMarkup keyboard) {
        SendMessage.SendMessageBuilder<?, ?> builder = SendMessage.builder()
                .chatId(chatId)
                .text(text);

        if (keyboard != null) {
            builder.replyMarkup(keyboard);
        }

        try {
            client.execute(builder.build());
        } catch (TelegramApiException e) {
            log.error("Не удалось отправить сообщение в чат {}: {}", chatId, e.getMessage(), e);
        }
    }
}