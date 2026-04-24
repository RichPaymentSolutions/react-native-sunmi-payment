package com.richpayment.sunmipayment.models.request;

public class TipAdjustmentParams {

    private String oriOrderId;
    private String oriTransactionId;
    private String oriApprovalCode;
    private String oriRetrievalReferenceNum;
    private long tipAmount;
    private String orderId;

    public TipAdjustmentParams() {
    }

    public TipAdjustmentParams(long tipAmount) {
        this.tipAmount = tipAmount;
    }

    public String getOriOrderId() {
        return oriOrderId;
    }

    public void setOriOrderId(String oriOrderId) {
        this.oriOrderId = oriOrderId;
    }

    public String getOriTransactionId() {
        return oriTransactionId;
    }

    public void setOriTransactionId(String oriTransactionId) {
        this.oriTransactionId = oriTransactionId;
    }

    public String getOriApprovalCode() {
        return oriApprovalCode;
    }

    public void setOriApprovalCode(String oriApprovalCode) {
        this.oriApprovalCode = oriApprovalCode;
    }

    public String getOriRetrievalReferenceNum() {
        return oriRetrievalReferenceNum;
    }

    public void setOriRetrievalReferenceNum(String oriRetrievalReferenceNum) {
        this.oriRetrievalReferenceNum = oriRetrievalReferenceNum;
    }

    public long getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(long tipAmount) {
        this.tipAmount = tipAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
