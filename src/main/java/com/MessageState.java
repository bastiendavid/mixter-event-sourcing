package com;

import com.event.MessageDeleted;
import com.event.MessageQuaked;

public class MessageState {
    boolean isDeleted;
    String author;

    public void visit(MessageDeleted event) {
        isDeleted = true;
    }

    public void visit(MessageQuaked event) {
        this.author = event.author;
    }
}
