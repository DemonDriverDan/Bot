package com.abbitt.trading.domain;


import java.util.List;

public class PlaceExecutionReport {

    private final String customerRef;
    private final ExecutionReportStatus status;
    private final ExecutionReportErrorCode errorCode;
    private final String marketId;
    private final List<PlaceInstructionReport> instructionReports;

    public PlaceExecutionReport(String customerRef, ExecutionReportStatus status,
                                ExecutionReportErrorCode errorCode, String marketId,
                                List<PlaceInstructionReport> instructionReports) {
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

    public List<PlaceInstructionReport> getInstructionReports() {
        return instructionReports;
    }

    @Override
    public String toString() {
        return "PlaceExecutionReport{" +
                "customerRef='" + customerRef + '\'' +
                ", status=" + status +
                ", errorCode=" + errorCode +
                ", marketId='" + marketId + '\'' +
                ", instructionReports=" + instructionReports +
                '}';
    }
}
