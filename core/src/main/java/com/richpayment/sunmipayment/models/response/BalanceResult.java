package com.richpayment.sunmipayment.models.response;

public final class BalanceResult {

    private final BaseResult base;
    private final Long balance;

    public BalanceResult(BaseResult base, Long balance) {
        this.base = base;
        this.balance = balance;
    }

    public BaseResult getBase() {
        return base;
    }

    public Long getBalance() {
        return balance;
    }
}
