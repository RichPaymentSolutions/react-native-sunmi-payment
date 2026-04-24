package com.richpayment.sunmipayment.models.request;

public class BatchParams {

    private boolean printReport = true;
    private String orderId;

    public boolean isPrintReport() {
        return printReport;
    }

    public void setPrintReport(boolean printReport) {
        this.printReport = printReport;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
