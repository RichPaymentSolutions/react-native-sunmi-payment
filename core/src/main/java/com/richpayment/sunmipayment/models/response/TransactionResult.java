package com.richpayment.sunmipayment.models.response;

public class TransactionResult {

    private final BaseResult base;
    private final Long approvedAmount;
    private final Long approvedTax;
    private final Long approvedTip;
    private final Long approvedSurcharge;
    private final String cardType;
    private final String cardName;
    private final String maskedPan;
    private final String transactionId;
    private final String approvalCode;
    private final String retrievalReferenceNum;
    private final String cvmResult;

    public TransactionResult(
            BaseResult base,
            Long approvedAmount,
            Long approvedTax,
            Long approvedTip,
            Long approvedSurcharge,
            String cardType,
            String cardName,
            String maskedPan,
            String transactionId,
            String approvalCode,
            String retrievalReferenceNum,
            String cvmResult
    ) {
        this.base = base;
        this.approvedAmount = approvedAmount;
        this.approvedTax = approvedTax;
        this.approvedTip = approvedTip;
        this.approvedSurcharge = approvedSurcharge;
        this.cardType = cardType;
        this.cardName = cardName;
        this.maskedPan = maskedPan;
        this.transactionId = transactionId;
        this.approvalCode = approvalCode;
        this.retrievalReferenceNum = retrievalReferenceNum;
        this.cvmResult = cvmResult;
    }

    protected TransactionResult(TransactionResult other) {
        this(
                other.base,
                other.approvedAmount,
                other.approvedTax,
                other.approvedTip,
                other.approvedSurcharge,
                other.cardType,
                other.cardName,
                other.maskedPan,
                other.transactionId,
                other.approvalCode,
                other.retrievalReferenceNum,
                other.cvmResult
        );
    }

    public BaseResult getBase() {
        return base;
    }

    public Long getApprovedAmount() {
        return approvedAmount;
    }

    public Long getApprovedTax() {
        return approvedTax;
    }

    public Long getApprovedTip() {
        return approvedTip;
    }

    public Long getApprovedSurcharge() {
        return approvedSurcharge;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public String getRetrievalReferenceNum() {
        return retrievalReferenceNum;
    }

    public String getCvmResult() {
        return cvmResult;
    }
}
