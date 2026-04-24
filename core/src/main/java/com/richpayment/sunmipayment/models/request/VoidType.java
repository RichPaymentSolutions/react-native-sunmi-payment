package com.richpayment.sunmipayment.models.request;

public enum VoidType {
    FULL("full"),
    PARTIAL("partial");

    private final String value;

    VoidType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
