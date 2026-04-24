package com.richpayment.sunmipayment.models.response;

public class BaseResult {

    private final String orderId;
    private final String resultCode;
    private final String resultMsg;
    private final int eventCode;
    private final String action;

    public BaseResult(String orderId, String resultCode, String resultMsg, int eventCode, String action) {
        this.orderId = orderId;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.eventCode = eventCode;
        this.action = action;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public int getEventCode() {
        return eventCode;
    }

    public String getAction() {
        return action;
    }
}
