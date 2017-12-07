package com.event;

public class MessageDeleted extends Event {

    private final String user;

    public MessageDeleted(String user) {
        this.user = user;
    }
}
