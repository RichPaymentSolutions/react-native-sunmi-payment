package com.richpayment.sunmipayment.models.response;

public final class ReadCardResult {

    private final BaseResult base;
    private final String track1;
    private final String track2;
    private final String track3;
    private final String cardNumber;
    private final String cardExpiredDate;
    private final String cardServiceCode;
    private final String cardHolderName;

    public ReadCardResult(BaseResult base, String track1, String track2, String track3, String cardNumber, String cardExpiredDate, String cardServiceCode, String cardHolderName) {
        this.base = base;
        this.track1 = track1;
        this.track2 = track2;
        this.track3 = track3;
        this.cardNumber = cardNumber;
        this.cardExpiredDate = cardExpiredDate;
        this.cardServiceCode = cardServiceCode;
        this.cardHolderName = cardHolderName;
    }

    public BaseResult getBase() {
        return base;
    }

    public String getTrack1() {
        return track1;
    }

    public String getTrack2() {
        return track2;
    }

    public String getTrack3() {
        return track3;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiredDate() {
        return cardExpiredDate;
    }

    public String getCardServiceCode() {
        return cardServiceCode;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }
}
