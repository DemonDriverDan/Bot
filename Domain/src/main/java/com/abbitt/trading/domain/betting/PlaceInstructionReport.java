package com.abbitt.trading.domain.betting;


import java.util.Date;

public class PlaceInstructionReport {

    private final InstructionReportStatus status;
    private final InstructionReportErrorCode errorCode;
    private final PlaceInstruction instruction;
    private final String betId;
    private final Date placedDate;
    private final double averagePriceMatched;
    private final double sizeMatched;

    public PlaceInstructionReport(InstructionReportStatus status,
                                  InstructionReportErrorCode errorCode,
                                  PlaceInstruction instruction, String betId, Date placedDate,
                                  double averagePriceMatched, double sizeMatched) {
        this.status = status;
        this.errorCode = errorCode;
        this.instruction = instruction;
        this.betId = betId;
        this.placedDate = placedDate;
        this.averagePriceMatched = averagePriceMatched;
        this.sizeMatched = sizeMatched;
    }

    public InstructionReportStatus getStatus() {
        return status;
    }

    public InstructionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public PlaceInstruction getInstruction() {
        return instruction;
    }

    public String getBetId() {
        return betId;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public double getAveragePriceMatched() {
        return averagePriceMatched;
    }

    public double getSizeMatched() {
        return sizeMatched;
    }

    @Override
    public String toString() {
        return "PlaceInstructionReport{" +
                "status=" + status +
                ", errorCode=" + errorCode +
                ", instruction=" + instruction +
                ", betId='" + betId + '\'' +
                ", placedDate=" + placedDate +
                ", averagePriceMatched=" + averagePriceMatched +
                ", sizeMatched=" + sizeMatched +
                '}';
    }
}
