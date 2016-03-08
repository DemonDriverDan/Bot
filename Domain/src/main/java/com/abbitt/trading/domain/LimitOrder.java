package com.abbitt.trading.domain;


public class LimitOrder {

    private final double size;
    private final double price;
    private final PersistenceType persistenceType;

    public LimitOrder(double size, double price, PersistenceType persistenceType) {
        this.size = size;
        this.price = price;
        this.persistenceType = persistenceType;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    @Override
    public String toString() {
        return "LimitOrder{" +
                "size=" + size +
                ", price=" + price +
                ", persistenceType=" + persistenceType +
                '}';
    }
}
