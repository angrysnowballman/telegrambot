package com.betbot.services;

import com.betbot.telegramm.bot.util.language.LocalizationService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeyboardService {
    private final LocalizationService localizationService;
    private final UserSessionService userSessionService;


    public KeyboardService(LocalizationService localizationService, UserSessionService userSessionService) {
        this.localizationService = localizationService;
        this.userSessionService = userSessionService;
    }

    public InlineKeyboardMarkup mainMenu(Long chatId) {
        List<InlineKeyboardRow> keyboard = new ArrayList<>();

        //TODO: подумать как сократить
        keyboard.add(new InlineKeyboardRow(
                createInlineButtonArgs(chatId, "button.balance", "menu.balance", userSessionService.getBalance(chatId)),
                createInlineButton(chatId, "button.language", "menu.language")
        ));

        return new InlineKeyboardMarkup(keyboard);
    }

    private InlineKeyboardButton createInlineButtonArgs(Long chatId, String text, String callbackData, Object args) {
        InlineKeyboardButton button = new InlineKeyboardButton(
                String.format(localizationService.getLocalizedMessage(chatId, text), args)
        );
        button.setCallbackData(callbackData);
        return button;
    }

    private InlineKeyboardButton createInlineButton(Long chatId, String text, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton(
                localizationService.getLocalizedMessage(chatId, text)
        );
        button.setCallbackData(callbackData);
        return button;
    }


}