package com.abbitt.trading.domain.stream;


public class MarketSubscriptionMessage extends StreamMessageBase implements RequestMessage {

    private static final String OP = "marketSubscription";

    private final boolean segmentationEnabled;
    private final String clk;
    private final String initialClk;
    private final long heartbeatMs;
    private final long conflateMs;
    private final StreamMarketFilter marketFilter;
    private final StreamMarketDataFilter marketDataFilter;

    public MarketSubscriptionMessage(boolean segmentationEnabled, String clk, String initialClk, long heartbeatMs,
                                     long conflateMs, StreamMarketFilter marketFilter,
                                     StreamMarketDataFilter marketDataFilter) {
        super(OP);
        this.segmentationEnabled = segmentationEnabled;
        this.clk = clk;
        this.initialClk = initialClk;
        this.heartbeatMs = heartbeatMs;
        this.conflateMs = conflateMs;
        this.marketFilter = marketFilter;
        this.marketDataFilter = marketDataFilter;
    }

    public MarketSubscriptionMessage(StreamMarketFilter marketFilter, StreamMarketDataFilter marketDataFilter) {
        super(OP);
        this.marketFilter = marketFilter;
        this.marketDataFilter = marketDataFilter;

        this.segmentationEnabled = false;
        this.clk = "";
        this.initialClk = "";
        this.heartbeatMs = 0;
        this.conflateMs = 0;
    }

    public boolean isSegmentationEnabled() {
        return segmentationEnabled;
    }

    public String getClk() {
        return clk;
    }

    public String getInitialClk() {
        return initialClk;
    }

    public long getHeartbeatMs() {
        return heartbeatMs;
    }

    public long getConflateMs() {
        return conflateMs;
    }

    public StreamMarketFilter getMarketFilter() {
        return marketFilter;
    }

    public StreamMarketDataFilter getMarketDataFilter() {
        return marketDataFilter;
    }

    @Override
    public String toString() {
        return "MarketSubscriptionMessage{" +
                "segmentationEnabled=" + segmentationEnabled +
                ", clk='" + clk + '\'' +
                ", initialClk='" + initialClk + '\'' +
                ", heartbeatMs=" + heartbeatMs +
                ", conflateMs=" + conflateMs +
                ", marketFilter=" + marketFilter +
                ", marketDataFilter=" + marketDataFilter +
                '}';
    }
}
