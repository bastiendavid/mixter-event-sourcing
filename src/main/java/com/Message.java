package com;

import com.event.MessageDeleted;
import com.event.MessageQuaked;

public class Message {

    History history = new History();

    private Message() {

    }

    public Message(History history) {
        this.history = history;
    }

    public static Message quack(String author, String content) {
        Message message = new Message();
        message.history.archive(new MessageQuaked(author, content));
        return message;
    }

    public void delete(String byUser) {
        MessageState state = history.computeMessage();
        if (!state.isDeleted && state.author.equals(byUser)) {
            history.archive(new MessageDeleted());
        }
    }
}
