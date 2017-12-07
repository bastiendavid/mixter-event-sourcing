package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Message {

    History history = new History();

    public Message() {

    }

    public Message(History history) {
        this.history = history;
    }

    public void quack() {
        history.add(new MessageQuackedEvent());
    }

    public void delete() {
        if (history.has(MessageDeletedEvent.class)) {
            return;
        }

        history.add(new MessageDeletedEvent());
    }
}
