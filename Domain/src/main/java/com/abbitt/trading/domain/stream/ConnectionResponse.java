package com.abbitt.trading.domain.stream;


public class ConnectionResponse extends StreamMessageBase {

    private static final String OP = "connection";

    private final String connectionId;

    public ConnectionResponse(String connectionId) {
        super(OP);
        this.connectionId = connectionId;
    }

    public String getConnectionId() {
        return connectionId;
    }

    @Override
    public String toString() {
        return "ConnectionResponse{" +
                "connectionId='" + connectionId + '\'' +
                '}';
    }
}
