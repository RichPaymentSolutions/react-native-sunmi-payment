package com.richpayment.sunmipayment.reactnative;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.List;

public class SunmiPaymentAutolinkPackage implements ReactPackage {
    private final SunmiPaymentPackage delegate = new SunmiPaymentPackage();

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return delegate.createNativeModules(reactContext);
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return delegate.createViewManagers(reactContext);
    }
}
