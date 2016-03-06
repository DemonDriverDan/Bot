package com.abbitt.trading.domain;


public class MarketOnCloseOrder {

    private final double liability;

    public MarketOnCloseOrder(double liability) {
        this.liability = liability;
    }

    public double getLiability() {
        return liability;
    }
}
