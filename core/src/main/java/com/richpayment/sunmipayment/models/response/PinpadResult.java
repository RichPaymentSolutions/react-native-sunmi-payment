package com.richpayment.sunmipayment.models.response;

public final class PinpadResult {

    private final BaseResult base;
    private final String pinBlock;
    private final String ksn;

    public PinpadResult(BaseResult base, String pinBlock, String ksn) {
        this.base = base;
        this.pinBlock = pinBlock;
        this.ksn = ksn;
    }

    public BaseResult getBase() {
        return base;
    }

    public String getPinBlock() {
        return pinBlock;
    }

    public String getKsn() {
        return ksn;
    }
}
