package com.richpayment.sunmipayment.models.request;

public class PurchaseParams {

    private long amount;
    private PaymentType paymentType = PaymentType.CREDIT;
    private String currency = "USD";
    private Long tip;
    private Long tax;
    private Long surcharge;
    private boolean printReceipt = true;
    private String orderId;

    public PurchaseParams() {
    }

    public PurchaseParams(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType != null ? paymentType : PaymentType.CREDIT;
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

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    public Long getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Long surcharge) {
        this.surcharge = surcharge;
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
