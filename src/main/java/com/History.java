package com;

import com.event.Event;
import com.event.MessageDeleted;
import com.event.MessageQuaked;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class History {

    List<Event> eventList = new ArrayList<>();

    public History() {

    }

    public History(List<Event> events) {
        eventList.addAll(events);
    }

    public void archive(Event event) {
        eventList.add(event);
    }

    public boolean has(Class<? extends Event> eventClass) {
        Stream<Event> events = eventList.stream().filter(event -> event.getClass() == eventClass);
        return events.count() > 0;
    }

    public int size() {
        return eventList.size();
    }

    public Event get(int i) {
        return eventList.get(i);
    }

    public MessageState computeMessage() {
        // Ugly implementation, to have the test green
        MessageState messageState = new MessageState();
        messageState.isDeleted = has(MessageDeleted.class);
        if (!eventList.isEmpty()) {
            MessageQuaked messageQuaked = (MessageQuaked) eventList.get(0);
            messageState.author = messageQuaked.author;
        }
        return messageState;
    }
}
