package com.abbitt.trading.domain.stream;


public class RequestMessage {

    private final String messageOp;

    private int id;

    protected RequestMessage(String messageOp) {
        this.messageOp = messageOp;
    }

    public String getMessageOp() {
        return messageOp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
