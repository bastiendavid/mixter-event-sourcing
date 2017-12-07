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

    public void quack(String author, String content) {
        history.archive(new QuackMessage(author, content));
    }

    public void delete(String author) {
        if (history.has(DeleteMessage.class)) {
            return;
        }

        history.archive(new DeleteMessage(author));
    }
}
