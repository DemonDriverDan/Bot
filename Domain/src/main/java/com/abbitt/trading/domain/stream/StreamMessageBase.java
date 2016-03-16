package com.abbitt.trading.domain.stream;


public class StreamMessageBase implements StreamMessage {

    private final String op;

    private int id;

    protected StreamMessageBase(String op) {
        this.op = op;
    }

    @Override
    public String getOp() {
        return op;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
