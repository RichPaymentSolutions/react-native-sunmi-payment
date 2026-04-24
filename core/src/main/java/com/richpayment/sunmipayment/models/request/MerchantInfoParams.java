package com.richpayment.sunmipayment.models.request;

public class MerchantInfoParams {

    private String orderId;

    public MerchantInfoParams() {
    }

    public MerchantInfoParams(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
