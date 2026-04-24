package com.richpayment.sunmipayment.models.response;

public final class MerchantInfoResult {

    private final BaseResult base;
    private final String merchantName;
    private final String terminalId;
    private final String merchantNumber;
    private final String address;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String phone;
    private final String currencyCode;

    public MerchantInfoResult(BaseResult base, String merchantName, String terminalId, String merchantNumber, String address, String city, String state, String zipCode, String phone, String currencyCode) {
        this.base = base;
        this.merchantName = merchantName;
        this.terminalId = terminalId;
        this.merchantNumber = merchantNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.currencyCode = currencyCode;
    }

    public BaseResult getBase() {
        return base;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
