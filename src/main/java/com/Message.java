package com;

import com.event.DeletedMessage;
import com.event.QuackedMessage;

public class Message {

    History history = new History();

    private Message() {

    }

    public Message(History history) {
        this.history = history;
    }

    public static Message quack(String author, String content) {
        Message message = new Message();
        message.history.archive(new QuackedMessage(author, content));
        return message;
    }

    public void delete(String author) {
        if (history.has(DeletedMessage.class)) {
            return;
        }

        history.archive(new DeletedMessage(author));
    }
}
