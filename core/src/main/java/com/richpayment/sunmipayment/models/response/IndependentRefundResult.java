package com.richpayment.sunmipayment.models.response;

public final class IndependentRefundResult extends RefundResult {

    public IndependentRefundResult(BaseResult base, Long approvedAmount, String transactionId, String approvalCode, String retrievalReferenceNum, String cvmResult) {
        super(base, approvedAmount, transactionId, approvalCode, retrievalReferenceNum, cvmResult);
    }
}
