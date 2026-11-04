package com.betbot.services;

import com.betbot.model.repository.UserSessionRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserSessionService {

    private final UserSessionRepository userSessionRepository;

    public UserSessionService(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    //getOrCreateUserSession (Long chatId)
    //getUserBalance (Long chatId)
    //addBalance (Long chatId, Int Amount)
    //getLocale (Long chatId,)
    //setLocale (Long chatId, String locale)
    //setUserState (Long chatId, Userstate state)
    //getUserState (Long chatId)

    public Locale getLocale(Long chatId){
        // возвращает из 17
        return Locale.ENGLISH;
    }

}
