package com.event;

public class QuackMessage extends Event {

    public String content;

    public QuackMessage(String author, String content) {
        super(author);
        this.content = content;
    }
}
