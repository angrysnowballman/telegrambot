package com.betbot.services;

import com.betbot.model.UserSession;
import com.betbot.model.repository.UserSessionRepository;
import com.betbot.telegramm.bot.model.UserState;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class UserSessionService {

    private final UserSessionRepository userSessionRepository;

    public UserSessionService(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    private UserSession getOrCreateUserSession(Long chatId) {
        Optional<UserSession> userSession = userSessionRepository.findByChatId(chatId);
        return userSession.orElseGet(() -> {
            UserSession newSession = new UserSession();
            newSession.setChatId(chatId);
            newSession.setBalance(0);
            newSession.setUserState(UserState.IDLE);
            newSession.setLocale(Locale.forLanguageTag("ru-RU")); // "en"
            return userSessionRepository.save(newSession);
        });
    }

    public int getBalance(Long chatId) {
        return getOrCreateUserSession(chatId).getBalance();
    }

    public void addBalance(Long chatId, int amount) {
        UserSession session = getOrCreateUserSession(chatId);
        session.setBalance(session.getBalance() + amount);
        userSessionRepository.save(session);
    }

    public Locale getLocale(Long chatId) {
        return getOrCreateUserSession(chatId).getLocale();
    }

    public void setLocale(Long chatId, Locale locale) {
        UserSession session = getOrCreateUserSession(chatId);
        session.setLocale(locale);
        userSessionRepository.save(session);
    }

    public UserState getState(Long chatId) {
        return getOrCreateUserSession(chatId).getUserState();
    }

    public void setUserState(Long chatId, UserState userState) {
        UserSession session = getOrCreateUserSession(chatId);
        session.setUserState(userState);
        userSessionRepository.save(session);
    }

    public void setReferralId(Long chatId, Long expertId){
        UserSession session = getOrCreateUserSession(chatId);
        session.setReferralId(expertId);
        userSessionRepository.save(session);
    }

    public Long getReferralId(Long chatId) {
        return getOrCreateUserSession(chatId).getReferralId();
    }
}
