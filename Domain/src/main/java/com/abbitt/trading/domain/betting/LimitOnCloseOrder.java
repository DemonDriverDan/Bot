package com.abbitt.trading.domain.betting;


public class LimitOnCloseOrder {

    private final double liability;
    private final double price;

    public LimitOnCloseOrder(double liability, double price) {
        this.liability = liability;
        this.price = price;
    }

    public double getLiability() {
        return liability;
    }

    public double getPrice() {
        return price;
    }
}
