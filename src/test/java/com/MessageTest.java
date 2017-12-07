package com;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MessageTest {

    @Test
    public void when_quack_message_then_message_quacked_is_raised() {
        // Given
        Message message = new Message();

        // When
        message.quack();

        // Then
        Assert.assertEquals(message.eventList.size(), 1);
        Assert.assertEquals(message.eventList.get(0).getClass(), MessageQuackedEvent.class);
    }

    @Test
    public void when_delete_message_then_message_deleted_is_raised() {
        // Given
        Message message = new Message();

        // When
        message.delete();

        // Then
        Assert.assertEquals(message.eventList.size(), 1);
        Assert.assertEquals(message.eventList.get(0).getClass(), MessageDeletedEvent.class);
    }

    @Test
    public void when_deleted_message_then_message_nothing_is_raised() {
        // Given
        List<Event> eventList = new ArrayList<>();
        eventList.add(new MessageDeletedEvent());
        Message message = new Message(eventList);

        // When
        message.delete();

        // Then
        Assert.assertEquals(message.eventList.size(), 1);
        Assert.assertEquals(message.eventList.get(0).getClass(), MessageDeletedEvent.class);
    }

}