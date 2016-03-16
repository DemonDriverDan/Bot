package com.abbitt.trading.domain.betting;


public class PlaceInstruction {

    private final OrderType orderType;
    private final long selectionId;
    private final double handicap;
    private final Side side;
    private final LimitOrder limitOrder;
    private final LimitOnCloseOrder limitOnCloseOrder;
    private final MarketOnCloseOrder marketOnCloseOrder;

    public PlaceInstruction(OrderType orderType, long selectionId, double handicap, Side side, LimitOrder limitOrder,
                            LimitOnCloseOrder limitOnCloseOrder, MarketOnCloseOrder marketOnCloseOrder) {
        this.orderType = orderType;
        this.selectionId = selectionId;
        this.handicap = handicap;
        this.side = side;
        this.limitOrder = limitOrder;
        this.limitOnCloseOrder = limitOnCloseOrder;
        this.marketOnCloseOrder = marketOnCloseOrder;
    }

    public PlaceInstruction(OrderType orderType, long selectionId, double handicap, Side side, LimitOrder limitOrder) {
        this(orderType, selectionId, handicap, side, limitOrder, null, null);
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public double getHandicap() {
        return handicap;
    }

    public Side getSide() {
        return side;
    }

    public LimitOrder getLimitOrder() {
        return limitOrder;
    }

    public LimitOnCloseOrder getLimitOnCloseOrder() {
        return limitOnCloseOrder;
    }

    public MarketOnCloseOrder getMarketOnCloseOrder() {
        return marketOnCloseOrder;
    }

    @Override
    public String toString() {
        return "PlaceInstruction{" +
                "orderType=" + orderType +
                ", selectionId=" + selectionId +
                ", handicap=" + handicap +
                ", side=" + side +
                ", limitOrder=" + limitOrder +
                ", limitOnCloseOrder=" + limitOnCloseOrder +
                ", marketOnCloseOrder=" + marketOnCloseOrder +
                '}';
    }

    public static class Builder {
        private OrderType orderType;
        private long selectionId;
        private double handicap = 0;
        private Side side;
        private LimitOrder limitOrder;
        private LimitOnCloseOrder limitOnCloseOrder;
        private MarketOnCloseOrder marketOnCloseOrder;

        public Builder withOrderType(OrderType orderType) {
            this.orderType = orderType;
            return this;
        }

        public Builder withSelectionId(long selectionId) {
            this.selectionId = selectionId;
            return this;
        }

        public Builder withHandicap(double handicap) {
            this.handicap = handicap;
            return this;
        }

        public Builder withSide(Side side) {
            this.side = side;
            return this;
        }

        public Builder withLimitOrder(LimitOrder limitOrder) {
            this.limitOrder = limitOrder;
            return this;
        }

        public Builder withLimitOnCloseOrder(LimitOnCloseOrder limitOnCloseOrder) {
            this.limitOnCloseOrder = limitOnCloseOrder;
            return this;
        }

        public Builder withMarketOnCloseOrder(MarketOnCloseOrder marketOnCloseOrder) {
            this.marketOnCloseOrder = marketOnCloseOrder;
            return this;
        }

        public PlaceInstruction build() {
            return new PlaceInstruction(orderType, selectionId, handicap, side, limitOrder, limitOnCloseOrder, marketOnCloseOrder);
        }
    }
}
