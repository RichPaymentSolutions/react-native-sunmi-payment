package com.richpayment.sunmipayment.models.response;

public final class SignatureResult {

    private final BaseResult base;
    private final String signature;
    private final String oriOrderId;

    public SignatureResult(BaseResult base, String signature, String oriOrderId) {
        this.base = base;
        this.signature = signature;
        this.oriOrderId = oriOrderId;
    }

    public BaseResult getBase() {
        return base;
    }

    public String getSignature() {
        return signature;
    }

    public String getOriOrderId() {
        return oriOrderId;
    }
}
