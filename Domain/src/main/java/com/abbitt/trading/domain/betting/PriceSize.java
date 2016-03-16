package com.abbitt.trading.domain.betting;


public class PriceSize {

    private final double price;
    private final double size;

    public PriceSize(double price, double size) {
        this.price = price;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }
}
