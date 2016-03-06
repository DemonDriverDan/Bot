package com.abbitt.trading.domain;


public class EventResult {

    private final Event event;
    private final int marketCount;

    public EventResult(Event event, int marketCount) {
        this.event = event;
        this.marketCount = marketCount;
    }

    public Event getEvent() {
        return event;
    }

    public int getMarketCount() {
        return marketCount;
    }
}
