package com.richpayment.sunmipayment.models.request;

public class TransactionCancelParams {

    private String orderId;

    public TransactionCancelParams() {
    }

    public TransactionCancelParams(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
