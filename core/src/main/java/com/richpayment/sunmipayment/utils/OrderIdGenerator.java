package com.richpayment.sunmipayment.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class OrderIdGenerator {

    private OrderIdGenerator() {
    }

    public static String generate() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String getCurrentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
    }
}
