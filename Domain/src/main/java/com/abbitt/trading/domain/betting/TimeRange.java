package com.abbitt.trading.domain.betting;


import java.util.Date;

public class TimeRange {

    private final Date from;
    private final Date to;

    public TimeRange(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }
}
