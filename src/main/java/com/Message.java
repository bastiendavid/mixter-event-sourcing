package com;

import com.event.DeleteMessage;
import com.event.QuackMessage;

public class Message {

    History history = new History();

    public Message() {

    }

    public Message(History history) {
        this.history = history;
    }

    public void quack() {
        history.archive(new QuackMessage());
    }

    public void delete() {
        if (history.has(DeleteMessage.class)) {
            return;
        }

        history.archive(new DeleteMessage());
    }
}
