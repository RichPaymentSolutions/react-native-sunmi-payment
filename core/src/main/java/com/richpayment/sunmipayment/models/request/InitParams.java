package com.richpayment.sunmipayment.models.request;

public class InitParams {

    private String orderId;

    public InitParams() {
    }

    public InitParams(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
