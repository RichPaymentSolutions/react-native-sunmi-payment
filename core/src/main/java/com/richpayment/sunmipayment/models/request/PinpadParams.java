package com.richpayment.sunmipayment.models.request;

public class PinpadParams {

    private String orderId;
    private int timeout = 60;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
