package com.richpayment.sunmipayment.models.response;

public final class InitResult {

    private final BaseResult base;

    public InitResult(BaseResult base) {
        this.base = base;
    }

    public BaseResult getBase() {
        return base;
    }
}
