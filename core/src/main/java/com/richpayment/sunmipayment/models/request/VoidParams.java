package com.richpayment.sunmipayment.models.request;

public class VoidParams {

    private String oriOrderId;
    private String oriTransactionId;
    private String oriApprovalCode;
    private String oriRetrievalReferenceNum;
    private VoidType voidType = VoidType.FULL;
    private Long amount;
    private boolean printReceipt = true;
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

    public VoidType getVoidType() {
        return voidType;
    }

    public void setVoidType(VoidType voidType) {
        this.voidType = voidType != null ? voidType : VoidType.FULL;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public boolean isPrintReceipt() {
        return printReceipt;
    }

    public void setPrintReceipt(boolean printReceipt) {
        this.printReceipt = printReceipt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
