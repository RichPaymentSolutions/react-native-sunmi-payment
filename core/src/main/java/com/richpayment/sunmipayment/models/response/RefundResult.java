package com.richpayment.sunmipayment.models.response;

public class RefundResult {

    private final BaseResult base;
    private final Long approvedAmount;
    private final String transactionId;
    private final String approvalCode;
    private final String retrievalReferenceNum;
    private final String cvmResult;

    public RefundResult(BaseResult base, Long approvedAmount, String transactionId, String approvalCode, String retrievalReferenceNum, String cvmResult) {
        this.base = base;
        this.approvedAmount = approvedAmount;
        this.transactionId = transactionId;
        this.approvalCode = approvalCode;
        this.retrievalReferenceNum = retrievalReferenceNum;
        this.cvmResult = cvmResult;
    }

    protected RefundResult(RefundResult other) {
        this(other.base, other.approvedAmount, other.transactionId, other.approvalCode, other.retrievalReferenceNum, other.cvmResult);
    }

    public BaseResult getBase() {
        return base;
    }

    public Long getApprovedAmount() {
        return approvedAmount;
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
