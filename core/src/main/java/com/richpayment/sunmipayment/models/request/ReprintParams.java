package com.richpayment.sunmipayment.models.request;

public class ReprintParams {

    private String oriOrderId;
    private String oriTransactionId;
    private String oriApprovalCode;
    private String oriRetrievalReferenceNum;
    private String orderId;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
