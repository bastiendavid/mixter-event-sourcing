package com;

import com.event.DeletedMessage;
import com.event.QuackedMessage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MessageTest {

    String author = "Author";
    String content = "Hello world";

    @Test
    public void when_quack_message_then_message_quacked_is_raised() {
        // Given
        // When
        Message message = Message.quack(author, content);

        // Then
        Assert.assertEquals(message.history.size(), 1);
        Assert.assertEquals(message.history.get(0).getClass(), QuackedMessage.class);
    }

    @Test
    public void when_delete_message_then_message_deleted_is_raised() {
        // Given
        Message message = Message.quack(author, content);

        // When
        message.delete(author);

        // Then
        Assert.assertEquals(message.history.size(), 2);
        Assert.assertEquals(message.history.get(0).getClass(), QuackedMessage.class);
        Assert.assertEquals(message.history.get(1).getClass(), DeletedMessage.class);
    }

    @Test
    public void when_deleted_message_then_message_nothing_is_raised() {
        // Given
        History history = new History(Arrays.asList(new QuackedMessage(author, content), new DeletedMessage(author)));
        Message message = new Message(history);

        // When
        message.delete(author);

        // Then
        Assert.assertEquals(message.history.size(), 2);
        Assert.assertEquals(message.history.get(0).getClass(), QuackedMessage.class);
        Assert.assertEquals(message.history.get(1).getClass(), DeletedMessage.class);
    }
}