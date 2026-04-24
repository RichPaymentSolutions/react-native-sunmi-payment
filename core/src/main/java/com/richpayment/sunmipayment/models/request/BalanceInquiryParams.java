package com.richpayment.sunmipayment.models.request;

public class BalanceInquiryParams {

    private String orderId;

    public BalanceInquiryParams() {
    }

    public BalanceInquiryParams(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
