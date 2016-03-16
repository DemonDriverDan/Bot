package com.abbitt.trading.domain.betting;


public class MarketOnCloseOrder {

    private final double liability;

    public MarketOnCloseOrder(double liability) {
        this.liability = liability;
    }

    public double getLiability() {
        return liability;
    }
}
