package com;

import com.event.DeleteMessage;
import com.event.QuackMessage;
import org.junit.Assert;
import org.junit.Test;

public class MessageTest {

    @Test
    public void when_quack_message_then_message_quacked_is_raised() {
        // Given
        Message message = new Message();

        // When
        message.quack();

        // Then
        Assert.assertEquals(message.history.size(), 1);
        Assert.assertEquals(message.history.get(0).getClass(), QuackMessage.class);
    }

    @Test
    public void when_delete_message_then_message_deleted_is_raised() {
        // Given
        Message message = new Message();

        // When
        message.delete();

        // Then
        Assert.assertEquals(message.history.size(), 1);
        Assert.assertEquals(message.history.get(0).getClass(), DeleteMessage.class);
    }

    @Test
    public void when_deleted_message_then_message_nothing_is_raised() {
        // Given
        History history = new History();
        history.archive(new DeleteMessage());
        Message message = new Message(history);

        // When
        message.delete();

        // Then
        Assert.assertEquals(message.history.size(), 1);
        Assert.assertEquals(message.history.get(0).getClass(), DeleteMessage.class);
    }

}