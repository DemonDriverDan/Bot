package com.abbitt.trading.domain.betting;


public enum EventTypeIds {

    HORSE_RACING("7");

    private final String value;

    EventTypeIds(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
