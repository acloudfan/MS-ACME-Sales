package com.acme.sales.model.tests.eventutil;

import com.acme.sales.model.utils.events.EventBus;
import com.acme.sales.model.utils.events.EventHandler;

public class MainTest {

    public static void main(String[] args){

        // Create a handler and register it
        EventHandler  handler = new SomeActionHappened();
        EventBus.register(AggregateRoot.SOME_ACTION_EVENT, handler);

        // Assume that an aggregate was pulled from the repository
        AggregateRoot  aggregateRoot = new AggregateRoot();

        // Some action taken on the aggregate
        aggregateRoot.someAction();

    }
}
