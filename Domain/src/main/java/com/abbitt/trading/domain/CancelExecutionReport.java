package com.abbitt.trading.domain;


import java.util.List;

public class CancelExecutionReport {

    private final String customerRef;
    private final ExecutionReportStatus status;
    private final ExecutionReportErrorCode errorCode;
    private final String marketId;
    private final List<CancelInstructionReport> instructionReports;

    public CancelExecutionReport(String customerRef, ExecutionReportStatus status, ExecutionReportErrorCode errorCode,
                                 String marketId, List<CancelInstructionReport> instructionReports) {
        this.customerRef = customerRef;
        this.status = status;
        this.errorCode = errorCode;
        this.marketId = marketId;
        this.instructionReports = instructionReports;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public ExecutionReportStatus getStatus() {
        return status;
    }

    public ExecutionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMarketId() {
        return marketId;
    }

    public List<CancelInstructionReport> getInstructionReports() {
        return instructionReports;
    }

    @Override
    public String toString() {
        return "CancelExecutionReport{" +
                "customerRef='" + customerRef + '\'' +
                ", status=" + status +
                ", errorCode=" + errorCode +
                ", marketId='" + marketId + '\'' +
                ", instructionReports=" + instructionReports +
                '}';
    }
}
