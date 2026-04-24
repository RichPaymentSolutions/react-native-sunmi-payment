package com.richpayment.sunmipayment.models.response;

import java.util.List;
import java.util.Map;

public final class HistoryResult {

    private final BaseResult base;
    private final List<Map<String, Object>> transactions;

    public HistoryResult(BaseResult base, List<Map<String, Object>> transactions) {
        this.base = base;
        this.transactions = transactions;
    }

    public BaseResult getBase() {
        return base;
    }

    public List<Map<String, Object>> getTransactions() {
        return transactions;
    }
}
