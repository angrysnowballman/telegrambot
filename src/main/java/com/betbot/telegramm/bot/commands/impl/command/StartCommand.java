package com.betbot.telegramm.bot.commands.impl.command;

import com.betbot.events.MessageEvent;
import com.betbot.services.KeyboardService;
import com.betbot.services.ReferralService;
import com.betbot.services.UserSessionService;
import com.betbot.telegramm.bot.commands.Command;
import com.betbot.telegramm.bot.commands.enums.CommandName;
import com.betbot.telegramm.bot.util.language.LocalizationService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand implements Command {
    private final ApplicationEventPublisher eventPublisher;
    private final LocalizationService localizationService;
    private final KeyboardService keyboardService;
    private final ReferralService referralService;


    private final UserSessionService userSessionService;

    public StartCommand(ApplicationEventPublisher eventPublisher,
                        LocalizationService localizationService,
                        KeyboardService keyboardService, ReferralService referralService, UserSessionService userSessionService
    ) {
        this.eventPublisher = eventPublisher;
        this.localizationService = localizationService;
        this.keyboardService = keyboardService;
        this.referralService = referralService;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean canHandle(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return false;
        }

        String message = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        Long referralId = referralService.getReferralId(message);

        if(!chatId.equals(referralId))userSessionService.setReferralId(chatId, referralId);

        String localizedMessage = localizationService.getLocalizedMessage(
                chatId,
                "menu.start"
        );

        return message.substring(0, 6).equals(localizedMessage);
    }

    @Override
    public void handle(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String userName = update.getMessage().getFrom().getUserName();

            String profileText = "тест описание";

            SendMessage message = SendMessage
                    .builder()
                    .chatId(chatId)
                    .text(profileText)
                    .replyMarkup(keyboardService.mainMenu(chatId))
                    .parseMode("HTML")
                    .build();
            eventPublisher.publishEvent(new MessageEvent(this, message));
        }
    }

    @Override
    public String getCommand() {
        return CommandName.START.getName();
    }


}