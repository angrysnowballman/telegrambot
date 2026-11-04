package com.betbot.factory;

public enum UserState {
    ACTIVE,     // может делать ставки
    INACTIVE,   // зарегистрирован, но не подтвердил, например, email/телефон
    BLOCKED
}
