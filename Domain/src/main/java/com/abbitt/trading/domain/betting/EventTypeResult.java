package com.abbitt.trading.domain.betting;


public class EventTypeResult {

    private final EventType eventType;
    private final int marketCount;

    public EventTypeResult(EventType eventType, int marketCount) {
        this.eventType = eventType;
        this.marketCount = marketCount;
    }

    public EventType getEventType() {
        return eventType;
    }

    public int getMarketCount() {
        return marketCount;
    }

    @Override
    public String toString() {
        return "EventTypeResult{" +
                "eventType=" + eventType +
                ", marketCount=" + marketCount +
                '}';
    }
}
