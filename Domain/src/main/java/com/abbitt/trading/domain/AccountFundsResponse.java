package com.abbitt.trading.domain;


public class AccountFundsResponse {

    private final double availableToBetBalance;
    private final double exposure;
    private final double retainedCommission;
    private final double exposureLimit;
    private final double discountRate;
    private final int pointsBalance;

    public AccountFundsResponse(double availableToBetBalance, double exposure, double retainedCommission,
                                double exposureLimit, double discountRate, int pointsBalance) {
        this.availableToBetBalance = availableToBetBalance;
        this.exposure = exposure;
        this.retainedCommission = retainedCommission;
        this.exposureLimit = exposureLimit;
        this.discountRate = discountRate;
        this.pointsBalance = pointsBalance;
    }

    public double getAvailableToBetBalance() {
        return availableToBetBalance;
    }

    public double getExposure() {
        return exposure;
    }

    public double getRetainedCommission() {
        return retainedCommission;
    }

    public double getExposureLimit() {
        return exposureLimit;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getPointsBalance() {
        return pointsBalance;
    }

    @Override
    public String toString() {
        return "AccountFundsResponse{" +
                "availableToBetBalance=" + availableToBetBalance +
                ", exposure=" + exposure +
                ", retainedCommission=" + retainedCommission +
                ", exposureLimit=" + exposureLimit +
                ", discountRate=" + discountRate +
                ", pointsBalance=" + pointsBalance +
                '}';
    }
}
