package com;

import com.event.Event;

import java.util.ArrayList;
import java.util.List;

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

    public int size() {
        return eventList.size();
    }

    public Event get(int i) {
        return eventList.get(i);
    }

    public MessageState computeMessage() {
        MessageState messageState = new MessageState();
        for (Event event : eventList) {
            event.accept(messageState);
        }
        return messageState;
    }
}
