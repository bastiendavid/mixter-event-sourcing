package com.event;

import com.MessageState;

public class MessageDeleted implements Event {

    @Override
    public void accept(MessageState messageState) {
        messageState.visit(this);
    }
}
