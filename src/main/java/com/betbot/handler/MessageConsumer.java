package com.betbot.handler;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessageConsumer {
    void  consume(Update update);

}
