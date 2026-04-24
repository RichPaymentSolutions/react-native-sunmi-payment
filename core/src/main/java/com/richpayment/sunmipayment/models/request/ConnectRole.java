package com.richpayment.sunmipayment.models.request;

public enum ConnectRole {
    MASTER("Master"),
    SLAVE("Slave");

    private final String value;

    ConnectRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
