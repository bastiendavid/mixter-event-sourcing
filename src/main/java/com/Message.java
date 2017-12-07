package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Message {

    List<Event> eventList = new ArrayList<>();

    public Message() {

    }

    public Message(List<Event> eventList) {
        this.eventList.addAll(eventList);
    }

    public void quack() {
        eventList.add(new MessageQuackedEvent());
    }

    public void delete() {

        Stream<Event> deletedEvents = eventList.stream().filter(event -> event instanceof MessageDeletedEvent);
        if (deletedEvents.count() > 0) {
            return;
        }

        eventList.add(new MessageDeletedEvent());
    }
}
