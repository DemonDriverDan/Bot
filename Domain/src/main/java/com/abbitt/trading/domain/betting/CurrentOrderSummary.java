package com.abbitt.trading.domain.betting;


import java.util.Date;

public class CurrentOrderSummary {

    private final String betId;
    private final String marketId;
    private final long selectionId;
    private final double handicap;
    private final PriceSize priceSize;
    private final double bspLiability;
    private final Side side;
    private final OrderStatus orderStatus;
    private final PersistenceType persistenceType;
    private final OrderType orderType;
    private final Date placedDate;
    private final Date matchedDate;
    private final double averagePriceMatched;
    private final double sizeMatched;
    private final double sizeRemaining;
    private final double sizeLapsed;
    private final double sizeCancelled;
    private final double sizeVoided;
    private final String regulatorAuthCode;
    private final String regulatorCode;

    public CurrentOrderSummary(String betId, String marketId, long selectionId, double handicap, PriceSize priceSize,
                               double bspLiability, Side side, OrderStatus orderStatus, PersistenceType persistenceType,
                               OrderType orderType, Date placedDate, Date matchedDate, double averagePriceMatched,
                               double sizeMatched, double sizeRemaining, double sizeLapsed, double sizeCancelled,
                               double sizeVoided, String regulatorAuthCode, String regulatorCode) {
        this.betId = betId;
        this.marketId = marketId;
        this.selectionId = selectionId;
        this.handicap = handicap;
        this.priceSize = priceSize;
        this.bspLiability = bspLiability;
        this.side = side;
        this.orderStatus = orderStatus;
        this.persistenceType = persistenceType;
        this.orderType = orderType;
        this.placedDate = placedDate;
        this.matchedDate = matchedDate;
        this.averagePriceMatched = averagePriceMatched;
        this.sizeMatched = sizeMatched;
        this.sizeRemaining = sizeRemaining;
        this.sizeLapsed = sizeLapsed;
        this.sizeCancelled = sizeCancelled;
        this.sizeVoided = sizeVoided;
        this.regulatorAuthCode = regulatorAuthCode;
        this.regulatorCode = regulatorCode;
    }

    public String getBetId() {
        return betId;
    }

    public String getMarketId() {
        return marketId;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public double getHandicap() {
        return handicap;
    }

    public PriceSize getPriceSize() {
        return priceSize;
    }

    public double getBspLiability() {
        return bspLiability;
    }

    public Side getSide() {
        return side;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public Date getMatchedDate() {
        return matchedDate;
    }

    public double getAveragePriceMatched() {
        return averagePriceMatched;
    }

    public double getSizeMatched() {
        return sizeMatched;
    }

    public double getSizeRemaining() {
        return sizeRemaining;
    }

    public double getSizeLapsed() {
        return sizeLapsed;
    }

    public double getSizeCancelled() {
        return sizeCancelled;
    }

    public double getSizeVoided() {
        return sizeVoided;
    }

    public String getRegulatorAuthCode() {
        return regulatorAuthCode;
    }

    public String getRegulatorCode() {
        return regulatorCode;
    }
}
