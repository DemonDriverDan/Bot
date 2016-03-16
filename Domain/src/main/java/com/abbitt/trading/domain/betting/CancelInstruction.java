package com.abbitt.trading.domain.betting;


public class CancelInstruction {

    private final String betId;
    private final Double sizeReduction;

    public CancelInstruction(String betId, Double sizeReduction) {
        this.betId = betId;
        this.sizeReduction = sizeReduction;
    }

    public CancelInstruction(String betId) {
        this(betId, null);
    }

    public String getBetId() {
        return betId;
    }

    public Double getSizeReduction() {
        return sizeReduction;
    }
}
