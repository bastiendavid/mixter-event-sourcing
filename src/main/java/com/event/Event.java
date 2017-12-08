package com.event;

import com.MessageState;

public interface Event {
    void accept(MessageState messageState);
}
