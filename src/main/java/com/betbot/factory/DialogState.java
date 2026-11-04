package com.betbot.factory;

public enum DialogState {
    IDLE,              // ничего не делает, ждёт команду
    CHOOSING_EVENT,    // смотрит список событий
    CHOOSING_OUTCOME,  // выбрал событие, выбирает исход
    AWAITING_AMOUNT,   // выбрал исход, вводит сумму
    CONFIRMING
}
