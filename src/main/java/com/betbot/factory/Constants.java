package com.betbot.factory;

public class Constants {

    public static final String CHAT_STATES = "chatStates";
    public static final String USER_STATUSES = "userStatuses";

    // тексты
    public static final String START_TEXT =
            "Добро пожаловать в Betting Bot!\nВыберите действие:";
    public static final String START_DESCRIPTION = "Запустить бота";
    public static final String EVENTS_PROMPT = "Ближайшие события:";
    public static final String CHOOSE_OUTCOME_PROMPT = "Выберите исход:";
    public static final String ENTER_AMOUNT_PROMPT =
            "Введите сумму ставки (мин. 100, макс. 10 000):";
    public static final String CONFIRM_PROMPT = "Подтвердите ставку:";
    public static final String BET_ACCEPTED_TEXT = "Ставка принята!";
    public static final String BLOCKED_TEXT = "Ваш аккаунт заблокирован.";
    public static final String INACTIVE_TEXT =
            "Подтвердите регистрацию, чтобы делать ставки.";

    // кнопки
    public static final String BTN_EVENTS = "📋 Список событий";
    public static final String BTN_MY_BETS = "🎫 Мои ставки";
    public static final String BTN_HELP = "ℹ️ Помощь";
    public static final String BTN_CONFIRM = "✅ Подтвердить";
    public static final String BTN_CANCEL = "❌ Отмена";

    // лимиты
    public static final long MIN_BET = 100L;
    public static final long MAX_BET = 10_000L;
}
