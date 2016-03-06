package com.abbitt.trading.domain;


import java.util.Date;

public class PlaceInstructionReport {

    private final InstructionReportStatus instructionReportStatus;
    private final InstructionReportErrorCode instructionReportErrorCode;
    private final PlaceInstruction placeInstruction;
    private final String betId;
    private final Date placedDate;
    private final double averagePriceMatched;
    private final double sizeMatched;

    public PlaceInstructionReport(InstructionReportStatus instructionReportStatus,
                                  InstructionReportErrorCode instructionReportErrorCode,
                                  PlaceInstruction placeInstruction, String betId, Date placedDate,
                                  double averagePriceMatched, double sizeMatched) {
        this.instructionReportStatus = instructionReportStatus;
        this.instructionReportErrorCode = instructionReportErrorCode;
        this.placeInstruction = placeInstruction;
        this.betId = betId;
        this.placedDate = placedDate;
        this.averagePriceMatched = averagePriceMatched;
        this.sizeMatched = sizeMatched;
    }

    public InstructionReportStatus getInstructionReportStatus() {
        return instructionReportStatus;
    }

    public InstructionReportErrorCode getInstructionReportErrorCode() {
        return instructionReportErrorCode;
    }

    public PlaceInstruction getPlaceInstruction() {
        return placeInstruction;
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
                "instructionReportStatus=" + instructionReportStatus +
                ", instructionReportErrorCode=" + instructionReportErrorCode +
                ", placeInstruction=" + placeInstruction +
                ", betId='" + betId + '\'' +
                ", placedDate=" + placedDate +
                ", averagePriceMatched=" + averagePriceMatched +
                ", sizeMatched=" + sizeMatched +
                '}';
    }
}
