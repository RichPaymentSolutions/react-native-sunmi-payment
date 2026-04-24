package com.richpayment.sunmipayment.callbacks;

public interface PaymentCallback<T> {
    void onEvent(int eventCode, String eventData);

    void onSuccess(T result);

    void onError(String code, String message);
}
