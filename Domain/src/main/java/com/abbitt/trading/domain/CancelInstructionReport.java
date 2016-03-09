package com.abbitt.trading.domain;


import java.util.Date;

public class CancelInstructionReport {

    private final InstructionReportStatus status;
    private final InstructionReportErrorCode errorCode;
    private final CancelInstruction instruction;
    private final double sizeCancelled;
    private final Date cancelledDate;

    public CancelInstructionReport(InstructionReportStatus status, InstructionReportErrorCode errorCode,
                                   CancelInstruction instruction, double sizeCancelled, Date cancelledDate) {
        this.status = status;
        this.errorCode = errorCode;
        this.instruction = instruction;
        this.sizeCancelled = sizeCancelled;
        this.cancelledDate = cancelledDate;
    }

    public InstructionReportStatus getStatus() {
        return status;
    }

    public InstructionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public CancelInstruction getInstruction() {
        return instruction;
    }

    public double getSizeCancelled() {
        return sizeCancelled;
    }

    public Date getCancelledDate() {
        return cancelledDate;
    }

    @Override
    public String toString() {
        return "CancelInstructionReport{" +
                "status=" + status +
                ", errorCode=" + errorCode +
                ", instruction=" + instruction +
                ", sizeCancelled=" + sizeCancelled +
                ", cancelledDate=" + cancelledDate +
                '}';
    }
}
