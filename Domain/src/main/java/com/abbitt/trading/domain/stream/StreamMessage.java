package com.abbitt.trading.domain.stream;


public interface StreamMessage {

    String getOp();
    int getId();
    void setId(int id);
}
