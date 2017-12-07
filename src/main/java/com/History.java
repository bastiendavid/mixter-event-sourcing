package com;

import com.event.Event;

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
        Stream<Event> deletedEvents = eventList.stream().filter(event -> event.getClass() == eventClass);
        return deletedEvents.count() > 0;
    }

    public int size() {
        return eventList.size();
    }

    public Event get(int i) {
        return eventList.get(i);
    }
}
