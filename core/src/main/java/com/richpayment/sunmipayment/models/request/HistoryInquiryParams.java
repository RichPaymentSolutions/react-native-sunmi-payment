package com.richpayment.sunmipayment.models.request;

public class HistoryInquiryParams {

    private String orderId;

    public HistoryInquiryParams() {
    }

    public HistoryInquiryParams(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
