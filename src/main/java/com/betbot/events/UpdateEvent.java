package com.betbot.events;

import org.springframework.context.ApplicationEvent;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateEvent extends ApplicationEvent {

    private final Update update;

    public UpdateEvent(Object source, Update update) {
        super(source);
        this.update = update;
    }

    public Update getUpdate() {
        return update;
    }
}