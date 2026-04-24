package com.richpayment.sunmipayment.models.response;

public final class PurchaseResult extends TransactionResult {

    public PurchaseResult(BaseResult base, Long approvedAmount, Long approvedTax, Long approvedTip, Long approvedSurcharge, String cardType, String cardName, String maskedPan, String transactionId, String approvalCode, String retrievalReferenceNum, String cvmResult) {
        super(base, approvedAmount, approvedTax, approvedTip, approvedSurcharge, cardType, cardName, maskedPan, transactionId, approvalCode, retrievalReferenceNum, cvmResult);
    }
}
