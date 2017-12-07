package com.event;

public class QuackedMessage extends Event {

    public String content;

    public QuackedMessage(String author, String content) {
        super(author);
        this.content = content;
    }
}
