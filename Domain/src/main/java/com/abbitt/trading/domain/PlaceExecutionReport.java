package com.abbitt.trading.domain;


import java.util.List;

public class PlaceExecutionReport {

    private final String customerRef;
    private final ExecutionReportStatus executionReportStatus;
    private final ExecutionReportErrorCode executionReportErrorCode;
    private final String marketId;
    private final List<PlaceInstructionReport> placeInstructionReports;

    public PlaceExecutionReport(String customerRef, ExecutionReportStatus executionReportStatus,
                                ExecutionReportErrorCode executionReportErrorCode, String marketId,
                                List<PlaceInstructionReport> placeInstructionReports) {
        this.customerRef = customerRef;
        this.executionReportStatus = executionReportStatus;
        this.executionReportErrorCode = executionReportErrorCode;
        this.marketId = marketId;
        this.placeInstructionReports = placeInstructionReports;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public ExecutionReportStatus getExecutionReportStatus() {
        return executionReportStatus;
    }

    public ExecutionReportErrorCode getExecutionReportErrorCode() {
        return executionReportErrorCode;
    }

    public String getMarketId() {
        return marketId;
    }

    public List<PlaceInstructionReport> getPlaceInstructionReports() {
        return placeInstructionReports;
    }

    @Override
    public String toString() {
        return "PlaceExecutionReport{" +
                "customerRef='" + customerRef + '\'' +
                ", executionReportStatus=" + executionReportStatus +
                ", executionReportErrorCode=" + executionReportErrorCode +
                ", marketId='" + marketId + '\'' +
                ", placeInstructionReports=" + placeInstructionReports +
                '}';
    }
}
