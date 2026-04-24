package com.richpayment.sunmipayment.models.request;

public class IndependentRefundParams {

    private long amount;
    private RefundType refundType = RefundType.CREDIT;
    private String currency = "USD";
    private boolean printReceipt = true;
    private String orderId;

    public IndependentRefundParams() {
    }

    public IndependentRefundParams(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public RefundType getRefundType() {
        return refundType;
    }

    public void setRefundType(RefundType refundType) {
        this.refundType = refundType != null ? refundType : RefundType.CREDIT;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency != null ? currency : "USD";
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
