package com.richpayment.sunmipayment.models.response;

public final class BatchResult {

    private final BaseResult base;
    private final String batchRecordCount;
    private final String batchNetDeposit;
    private final String batchNumber;

    public BatchResult(BaseResult base, String batchRecordCount, String batchNetDeposit, String batchNumber) {
        this.base = base;
        this.batchRecordCount = batchRecordCount;
        this.batchNetDeposit = batchNetDeposit;
        this.batchNumber = batchNumber;
    }

    public BaseResult getBase() {
        return base;
    }

    public String getBatchRecordCount() {
        return batchRecordCount;
    }

    public String getBatchNetDeposit() {
        return batchNetDeposit;
    }

    public String getBatchNumber() {
        return batchNumber;
    }
}
