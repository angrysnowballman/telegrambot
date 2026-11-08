package com.betbot.services;


import com.betbot.telegramm.bot.util.language.LocalizationService;
import org.springframework.stereotype.Service;

@Service
public class ReferralService {
    private final LocalizationService localizationService;

    public ReferralService(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    public Long getReferralId(String message){
        if(message.length()<7) return null;
        return Long.parseLong(message.substring(7));
    }
}
