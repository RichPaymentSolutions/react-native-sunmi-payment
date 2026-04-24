package com.richpayment.sunmipayment.models.request;

public enum ConnectType {
    ON_DEVICE("LOCAL"),
    VSP("VSP"),
    USB("USB"),
    WIFI("WIFI"),
    BLUETOOTH("Bluetooth"),
    RS232("RS232"),
    DOCK("DOCK");

    private final String mode;

    ConnectType(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
