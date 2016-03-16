package com.abbitt.trading.domain.stream;


public class StreamMessageBase implements StreamMessage {

    private final String messageOp;

    private int id;

    protected StreamMessageBase(String messageOp) {
        this.messageOp = messageOp;
    }

    @Override
    public String getOp() {
        return messageOp;
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
