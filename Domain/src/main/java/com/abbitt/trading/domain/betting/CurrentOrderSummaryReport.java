package com.abbitt.trading.domain.betting;


import java.util.List;

public class CurrentOrderSummaryReport {

    private final List<CurrentOrderSummary> currentOrders;
    private final boolean moreAvailable;

    public CurrentOrderSummaryReport(List<CurrentOrderSummary> currentOrders, boolean moreAvailable) {
        this.currentOrders = currentOrders;
        this.moreAvailable = moreAvailable;
    }

    public List<CurrentOrderSummary> getCurrentOrders() {
        return currentOrders;
    }

    public boolean isMoreAvailable() {
        return moreAvailable;
    }

    @Override
    public String toString() {
        return "CurrentOrderSummaryReport{" +
                "currentOrders=" + currentOrders +
                ", moreAvailable=" + moreAvailable +
                '}';
    }
}
