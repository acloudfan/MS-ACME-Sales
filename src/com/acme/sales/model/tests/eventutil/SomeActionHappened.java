package com.acme.sales.model.tests.eventutil;

import com.acme.sales.model.utils.events.Event;
import com.acme.sales.model.utils.events.EventHandler;

public class SomeActionHappened implements EventHandler {
    @Override
    public void handle(Event event) {
        System.out.println(this.getClass()+": Handler executed");
    }
}
