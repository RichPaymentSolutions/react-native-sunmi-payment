package com.richpayment.sunmipayment.models.request;

public enum PaymentType {
    CREDIT("credit"),
    DEBIT("debit"),
    CASH("cash"),
    EBT_BENEFIT("ebt_benefit"),
    EBT_E_VOUCHER("ebt_e_voucher"),
    EBT_FOOD_STAMP("ebt_food_stamp"),
    EBT_WITHDRAWAL("ebt_withdrawal");

    private final String value;

    PaymentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
