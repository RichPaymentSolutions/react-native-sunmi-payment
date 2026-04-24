package com.richpayment.sunmipayment.utils;

import android.os.Bundle;

import com.richpayment.sunmipayment.models.request.ConnectParams;
import com.richpayment.sunmipayment.models.request.ConnectType;

public final class SunmiConnectBundle {

    private static final String KEY_MODE = "mode";
    private static final String KEY_PACKAGE_NAME = "packageName";
    private static final String KEY_TYPE = "type";
    private static final String KEY_WIFI_PORT = "WIFIPort";
    private static final String KEY_WIFI_ADDRESS = "WIFIAddress";
    private static final String KEY_BAUD_RATE = "baudRate";
    private static final String KEY_DATA_BITS = "DataBits";
    private static final String KEY_PARITY = "Parity";
    private static final String KEY_STOP_BITS = "StopBits";

    private SunmiConnectBundle() {
    }

    public static Bundle build(ConnectParams params) {
        ConnectParams actualParams = params != null ? params : new ConnectParams();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MODE, actualParams.getConnectType().getMode());
        bundle.putString(KEY_TYPE, actualParams.getType().getValue());

        if (actualParams.getConnectType() == ConnectType.ON_DEVICE && actualParams.getPackageName() != null) {
            bundle.putString(KEY_PACKAGE_NAME, actualParams.getPackageName());
        }
        if (actualParams.getWifiAddress() != null) {
            bundle.putString(KEY_WIFI_ADDRESS, actualParams.getWifiAddress());
        }
        if (actualParams.getWifiPort() != null) {
            bundle.putInt(KEY_WIFI_PORT, actualParams.getWifiPort());
        }
        if (actualParams.getBaudRate() != null) {
            bundle.putInt(KEY_BAUD_RATE, actualParams.getBaudRate());
        }
        if (actualParams.getDataBits() != null) {
            bundle.putInt(KEY_DATA_BITS, actualParams.getDataBits());
        }
        if (actualParams.getParity() != null) {
            bundle.putString(KEY_PARITY, actualParams.getParity());
        }
        if (actualParams.getStopBits() != null) {
            bundle.putInt(KEY_STOP_BITS, actualParams.getStopBits());
        }
        return bundle;
    }
}
