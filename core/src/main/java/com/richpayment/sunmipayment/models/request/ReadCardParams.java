package com.richpayment.sunmipayment.models.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadCardParams {

    private List<Integer> readCardTypes = new ArrayList<>(Collections.singletonList(1));
    private int timeout = 60;
    private String orderId;

    public List<Integer> getReadCardTypes() {
        return readCardTypes;
    }

    public void setReadCardTypes(List<Integer> readCardTypes) {
        this.readCardTypes = readCardTypes != null ? new ArrayList<>(readCardTypes) : new ArrayList<>();
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
