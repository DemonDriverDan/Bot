package com.abbitt.trading.domain.stream;


public class AuthenticationMessage extends StreamMessageBase implements RequestMessage {

    private static final String OP = "authentication";

    private final String appKey;

    public AuthenticationMessage(String appKey) {
        super(OP);
        this.appKey = appKey;
    }

    public String getAppKey() {
        return appKey;
    }

    @Override
    public String toString() {
        return "AuthenticationMessage{" +
                "appKey='" + appKey + '\'' +
                '}';
    }
}
