package com.event;

public class MessageQuaked extends Event {

    public final String author;
    public final String content;

    public MessageQuaked(String author, String content) {
        this.author = author;
        this.content = content;
    }
}
