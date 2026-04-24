package com.richpayment.sunmipayment.models.request;

public enum RefundType {
    CREDIT("credit"),
    DEBIT("debit"),
    EBT("ebt");

    private final String value;

    RefundType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
