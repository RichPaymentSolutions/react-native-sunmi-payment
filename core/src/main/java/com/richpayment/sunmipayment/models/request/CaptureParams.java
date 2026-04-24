package com.richpayment.sunmipayment.models.request;

public class CaptureParams {

    private String oriOrderId;
    private String oriTransactionId;
    private String oriApprovalCode;
    private String oriRetrievalReferenceNum;
    private long amount;
    private String currency = "USD";
    private Long tip;
    private Long surcharge;
    private Long tax;
    private boolean printReceipt = true;
    private String orderId;

    public CaptureParams() {
    }

    public CaptureParams(long amount) {
        this.amount = amount;
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency != null ? currency : "USD";
    }

    public Long getTip() {
        return tip;
    }

    public void setTip(Long tip) {
        this.tip = tip;
    }

    public Long getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Long surcharge) {
        this.surcharge = surcharge;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
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
