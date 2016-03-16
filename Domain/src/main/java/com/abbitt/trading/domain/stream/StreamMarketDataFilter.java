package com.abbitt.trading.domain.stream;


import java.util.Set;

public class StreamMarketDataFilter {

    private final int ladderLevels;
    private final Set<Fields> fields;

    public StreamMarketDataFilter(int ladderLevels, Set<Fields> fields) {
        this.ladderLevels = ladderLevels;
        this.fields = fields;
    }

    public int getLadderLevels() {
        return ladderLevels;
    }

    public Set<Fields> getFields() {
        return fields;
    }

    public enum Fields {
        EX_BEST_OFFERS_DISP,
        EX_BEST_OFFERS,
        EX_ALL_OFFERS,
        EX_TRADED,
        EX_TRADED_VOL,
        EX_LTP,
        EX_MARKET_DEF,
        SP_TRADED,
        SP_PROJECTED
    }
}
