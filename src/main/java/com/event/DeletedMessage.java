package com.event;

public class DeletedMessage extends Event {

    public DeletedMessage(String author) {
        super(author);
    }
}
