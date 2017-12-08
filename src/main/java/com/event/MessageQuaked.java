package com.event;

import com.MessageState;

public class MessageQuaked implements Event {

    public final String author;
    public final String content;

    public MessageQuaked(String author, String content) {
        this.author = author;
        this.content = content;
    }

    @Override
    public void accept(MessageState messageState) {
        messageState.visit(this);
    }
}
