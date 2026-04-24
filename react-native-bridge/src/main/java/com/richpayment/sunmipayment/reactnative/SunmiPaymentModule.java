package com.richpayment.sunmipayment.reactnative;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.richpayment.sunmipayment.SunmiPaymentManager;
import com.richpayment.sunmipayment.callbacks.PaymentCallback;
import com.richpayment.sunmipayment.models.request.BalanceInquiryParams;
import com.richpayment.sunmipayment.models.request.BatchParams;
import com.richpayment.sunmipayment.models.request.CardAuthParams;
import com.richpayment.sunmipayment.models.request.CaptureParams;
import com.richpayment.sunmipayment.models.request.ConnectParams;
import com.richpayment.sunmipayment.models.request.ForceAuthParams;
import com.richpayment.sunmipayment.models.request.HistoryInquiryParams;
import com.richpayment.sunmipayment.models.request.IndependentRefundParams;
import com.richpayment.sunmipayment.models.request.InitParams;
import com.richpayment.sunmipayment.models.request.IncrementalAuthParams;
import com.richpayment.sunmipayment.models.request.MerchantInfoParams;
import com.richpayment.sunmipayment.models.request.PinpadParams;
import com.richpayment.sunmipayment.models.request.PreAuthParams;
import com.richpayment.sunmipayment.models.request.PurchaseParams;
import com.richpayment.sunmipayment.models.request.ReadCardParams;
import com.richpayment.sunmipayment.models.request.RefundParams;
import com.richpayment.sunmipayment.models.request.ReprintParams;
import com.richpayment.sunmipayment.models.request.SignatureParams;
import com.richpayment.sunmipayment.models.request.TipAdjustmentParams;
import com.richpayment.sunmipayment.models.request.TransactionCancelParams;
import com.richpayment.sunmipayment.models.request.VoidParams;
import com.richpayment.sunmipayment.models.response.BalanceResult;
import com.richpayment.sunmipayment.models.response.BaseResult;
import com.richpayment.sunmipayment.models.response.BatchResult;
import com.richpayment.sunmipayment.models.response.CardAuthResult;
import com.richpayment.sunmipayment.models.response.CaptureResult;
import com.richpayment.sunmipayment.models.response.ForceAuthResult;
import com.richpayment.sunmipayment.models.response.HistoryResult;
import com.richpayment.sunmipayment.models.response.IndependentRefundResult;
import com.richpayment.sunmipayment.models.response.InitResult;
import com.richpayment.sunmipayment.models.response.IncrementalAuthResult;
import com.richpayment.sunmipayment.models.response.MerchantInfoResult;
import com.richpayment.sunmipayment.models.response.PinpadResult;
import com.richpayment.sunmipayment.models.response.PreAuthResult;
import com.richpayment.sunmipayment.models.response.PurchaseResult;
import com.richpayment.sunmipayment.models.response.ReadCardResult;
import com.richpayment.sunmipayment.models.response.RefundResult;
import com.richpayment.sunmipayment.models.response.SignatureResult;
import com.richpayment.sunmipayment.models.response.TransactionResult;
import com.richpayment.sunmipayment.models.response.VoidResult;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SunmiPaymentModule extends ReactContextBaseJavaModule {

    public static final String NAME = "SunmiPayment";
    public static final String EVENT_NAME = "SunmiPaymentEvent";
    private static final Object UNSET = new Object();

    private final ReactApplicationContext reactContext;
    private final SunmiPaymentManager manager;

    public SunmiPaymentModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.manager = SunmiPaymentManager.create(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void connect(@Nullable ReadableMap params, Promise promise) {
        try {
            ConnectParams request = mapToParams(params, ConnectParams.class);
            manager.connect(
                    request,
                    () -> promise.resolve(true),
                    message -> promise.reject("CONNECT_ERROR", message)
            );
        } catch (Exception exception) {
            promise.reject("CONNECT_ERROR", exception);
        }
    }

    @ReactMethod
    public void disconnect() {
        manager.disconnect();
    }

    @ReactMethod
    public void isConnected(Promise promise) {
        promise.resolve(manager.isConnected());
    }

    @ReactMethod
    public void addListener(String eventName) {
    }

    @ReactMethod
    public void removeListeners(double count) {
    }

    @ReactMethod
    public void init(@Nullable ReadableMap params, Promise promise) {
        this.<InitParams, InitResult>executeOperation("init", params, InitParams.class, promise, (request, callback) -> manager.init(request, callback));
    }

    @ReactMethod
    public void historyInquiry(@Nullable ReadableMap params, Promise promise) {
        this.<HistoryInquiryParams, HistoryResult>executeOperation("historyInquiry", params, HistoryInquiryParams.class, promise, (request, callback) -> manager.historyInquiry(request, callback));
    }

    @ReactMethod
    public void batch(@Nullable ReadableMap params, Promise promise) {
        this.<BatchParams, BatchResult>executeOperation("batch", params, BatchParams.class, promise, (request, callback) -> manager.batch(request, callback));
    }

    @ReactMethod
    public void getMerchantInfo(@Nullable ReadableMap params, Promise promise) {
        this.<MerchantInfoParams, MerchantInfoResult>executeOperation("getMerchantInfo", params, MerchantInfoParams.class, promise, (request, callback) -> manager.getMerchantInfo(request, callback));
    }

    @ReactMethod
    public void purchase(@Nullable ReadableMap params, Promise promise) {
        this.<PurchaseParams, PurchaseResult>executeOperation("purchase", params, PurchaseParams.class, promise, (request, callback) -> manager.purchase(request, callback));
    }

    @ReactMethod
    public void voidTransaction(@Nullable ReadableMap params, Promise promise) {
        this.<VoidParams, VoidResult>executeOperation("void", params, VoidParams.class, promise, (request, callback) -> manager.void_(request, callback));
    }

    @ReactMethod
    public void independentRefund(@Nullable ReadableMap params, Promise promise) {
        this.<IndependentRefundParams, IndependentRefundResult>executeOperation("independentRefund", params, IndependentRefundParams.class, promise, (request, callback) -> manager.independentRefund(request, callback));
    }

    @ReactMethod
    public void refund(@Nullable ReadableMap params, Promise promise) {
        this.<RefundParams, RefundResult>executeOperation("refund", params, RefundParams.class, promise, (request, callback) -> manager.refund(request, callback));
    }

    @ReactMethod
    public void preAuthorization(@Nullable ReadableMap params, Promise promise) {
        this.<PreAuthParams, PreAuthResult>executeOperation("preAuthorization", params, PreAuthParams.class, promise, (request, callback) -> manager.preAuthorization(request, callback));
    }

    @ReactMethod
    public void capture(@Nullable ReadableMap params, Promise promise) {
        this.<CaptureParams, CaptureResult>executeOperation("capture", params, CaptureParams.class, promise, (request, callback) -> manager.capture(request, callback));
    }

    @ReactMethod
    public void forceAuthorization(@Nullable ReadableMap params, Promise promise) {
        this.<ForceAuthParams, ForceAuthResult>executeOperation("forceAuthorization", params, ForceAuthParams.class, promise, (request, callback) -> manager.forceAuthorization(request, callback));
    }

    @ReactMethod
    public void tipAdjustment(@Nullable ReadableMap params, Promise promise) {
        this.<TipAdjustmentParams, TransactionResult>executeOperation("tipAdjustment", params, TipAdjustmentParams.class, promise, (request, callback) -> manager.tipAdjustment(request, callback));
    }

    @ReactMethod
    public void incrementalAuthorization(@Nullable ReadableMap params, Promise promise) {
        this.<IncrementalAuthParams, IncrementalAuthResult>executeOperation("incrementalAuthorization", params, IncrementalAuthParams.class, promise, (request, callback) -> manager.incrementalAuthorization(request, callback));
    }

    @ReactMethod
    public void cardAuthentication(@Nullable ReadableMap params, Promise promise) {
        this.<CardAuthParams, CardAuthResult>executeOperation("cardAuthentication", params, CardAuthParams.class, promise, (request, callback) -> manager.cardAuthentication(request, callback));
    }

    @ReactMethod
    public void balanceInquiry(@Nullable ReadableMap params, Promise promise) {
        this.<BalanceInquiryParams, BalanceResult>executeOperation("balanceInquiry", params, BalanceInquiryParams.class, promise, (request, callback) -> manager.balanceInquiry(request, callback));
    }

    @ReactMethod
    public void transactionCancel(@Nullable ReadableMap params, Promise promise) {
        this.<TransactionCancelParams, BaseResult>executeOperation("transactionCancel", params, TransactionCancelParams.class, promise, (request, callback) -> manager.transactionCancel(request, callback));
    }

    @ReactMethod
    public void applySignature(@Nullable ReadableMap params, Promise promise) {
        this.<SignatureParams, SignatureResult>executeOperation("applySignature", params, SignatureParams.class, promise, (request, callback) -> manager.applySignature(request, callback));
    }

    @ReactMethod
    public void getSignature(@Nullable ReadableMap params, Promise promise) {
        this.<SignatureParams, SignatureResult>executeOperation("getSignature", params, SignatureParams.class, promise, (request, callback) -> manager.getSignature(request, callback));
    }

    @ReactMethod
    public void reprint(@Nullable ReadableMap params, Promise promise) {
        this.<ReprintParams, BaseResult>executeOperation("reprint", params, ReprintParams.class, promise, (request, callback) -> manager.reprint(request, callback));
    }

    @ReactMethod
    public void readCard(@Nullable ReadableMap params, Promise promise) {
        this.<ReadCardParams, ReadCardResult>executeOperation("readCard", params, ReadCardParams.class, promise, (request, callback) -> manager.readCard(request, callback));
    }

    @ReactMethod
    public void pinPad(@Nullable ReadableMap params, Promise promise) {
        this.<PinpadParams, PinpadResult>executeOperation("pinPad", params, PinpadParams.class, promise, (request, callback) -> manager.pinPad(request, callback));
    }

    private <P, R> void executeOperation(
            String operation,
            @Nullable ReadableMap params,
            Class<P> paramsClass,
            Promise promise,
            Operation<P, R> runner
    ) {
        try {
            P request = mapToParams(params, paramsClass);
            runner.run(request, new PaymentCallback<R>() {
                @Override
                public void onEvent(int eventCode, String eventData) {
                    emitEvent(operation, eventCode, eventData);
                }

                @Override
                public void onSuccess(R result) {
                    promise.resolve(toReactValue(result));
                }

                @Override
                public void onError(String code, String message) {
                    promise.reject(code, message);
                }
            });
        } catch (Exception exception) {
            promise.reject(operation.toUpperCase(Locale.US) + "_ERROR", exception);
        }
    }

    private void emitEvent(String operation, int eventCode, @Nullable String eventData) {
        if (!reactContext.hasActiveCatalystInstance()) {
            return;
        }
        WritableMap payload = Arguments.createMap();
        payload.putString("operation", operation);
        payload.putInt("eventCode", eventCode);
        if (eventData == null) {
            payload.putNull("eventData");
        } else {
            payload.putString("eventData", eventData);
        }
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(EVENT_NAME, payload);
    }

    private <T> T mapToParams(@Nullable ReadableMap map, Class<T> clazz) throws Exception {
        T target = clazz.getDeclaredConstructor().newInstance();
        if (map == null) {
            return target;
        }
        applyReadableMap(map, target);
        return target;
    }

    private void applyReadableMap(ReadableMap map, Object target) throws Exception {
        ReadableMapKeySetIterator iterator = map.keySetIterator();
        while (iterator.hasNextKey()) {
            String key = iterator.nextKey();
            Method setter = findSetter(target.getClass(), key);
            if (setter == null) {
                continue;
            }
            Object value = convertReadableValue(map, key, setter.getParameterTypes()[0]);
            if (value == UNSET) {
                continue;
            }
            setter.invoke(target, value);
        }
    }

    @Nullable
    private Method findSetter(Class<?> targetClass, String key) {
        String setterName = "set" + Character.toUpperCase(key.charAt(0)) + key.substring(1);
        for (Method method : targetClass.getMethods()) {
            if (method.getName().equals(setterName) && method.getParameterTypes().length == 1) {
                return method;
            }
        }
        return null;
    }

    private Object convertReadableValue(ReadableMap map, String key, Class<?> targetType) {
        if (!map.hasKey(key)) {
            return UNSET;
        }
        if (map.isNull(key)) {
            return null;
        }

        ReadableType readableType = map.getType(key);
        if (targetType == String.class) {
            return readableType == ReadableType.String ? map.getString(key) : String.valueOf(toJavaValue(map, key));
        }
        if (targetType == boolean.class || targetType == Boolean.class) {
            return map.getBoolean(key);
        }
        if (targetType == int.class || targetType == Integer.class) {
            return (int) Math.round(map.getDouble(key));
        }
        if (targetType == long.class || targetType == Long.class) {
            return Math.round(map.getDouble(key));
        }
        if (targetType == double.class || targetType == Double.class) {
            return map.getDouble(key);
        }
        if (List.class.isAssignableFrom(targetType)) {
            return readableType == ReadableType.Array ? readableArrayToList(map.getArray(key)) : null;
        }
        if (Map.class.isAssignableFrom(targetType)) {
            return readableType == ReadableType.Map ? readableMapToJavaMap(map.getMap(key)) : null;
        }
        if (targetType.isEnum()) {
            return parseEnum(targetType, map.getString(key));
        }
        if (readableType == ReadableType.Map) {
            try {
                Object nested = targetType.getDeclaredConstructor().newInstance();
                applyReadableMap(map.getMap(key), nested);
                return nested;
            } catch (Exception ignored) {
                return UNSET;
            }
        }
        return UNSET;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private Object parseEnum(Class<?> enumType, @Nullable String rawValue) {
        if (rawValue == null) {
            return null;
        }
        for (Object constant : enumType.getEnumConstants()) {
            Enum enumValue = (Enum) constant;
            if (enumValue.name().equalsIgnoreCase(rawValue)) {
                return enumValue;
            }
            try {
                Method valueGetter = enumType.getMethod("getValue");
                Object mappedValue = valueGetter.invoke(enumValue);
                if (mappedValue != null && rawValue.equalsIgnoreCase(String.valueOf(mappedValue))) {
                    return enumValue;
                }
            } catch (Exception ignored) {
            }
        }
        return Enum.valueOf((Class<? extends Enum>) enumType, normalizeEnumName(rawValue));
    }

    private String normalizeEnumName(String rawValue) {
        return rawValue
                .trim()
                .replace('-', '_')
                .replace(' ', '_')
                .toUpperCase(Locale.US);
    }

    private Object toJavaValue(ReadableMap map, String key) {
        ReadableType type = map.getType(key);
        switch (type) {
            case Boolean:
                return map.getBoolean(key);
            case Number:
                return numberFromDouble(map.getDouble(key));
            case String:
                return map.getString(key);
            case Map:
                return readableMapToJavaMap(map.getMap(key));
            case Array:
                return readableArrayToList(map.getArray(key));
            case Null:
            default:
                return null;
        }
    }

    private List<Object> readableArrayToList(@Nullable ReadableArray array) {
        if (array == null) {
            return Collections.emptyList();
        }
        List<Object> result = new ArrayList<>();
        for (int index = 0; index < array.size(); index++) {
            ReadableType type = array.getType(index);
            switch (type) {
                case Boolean:
                    result.add(array.getBoolean(index));
                    break;
                case Number:
                    result.add(numberFromDouble(array.getDouble(index)));
                    break;
                case String:
                    result.add(array.getString(index));
                    break;
                case Map:
                    result.add(readableMapToJavaMap(array.getMap(index)));
                    break;
                case Array:
                    result.add(readableArrayToList(array.getArray(index)));
                    break;
                case Null:
                default:
                    result.add(null);
                    break;
            }
        }
        return result;
    }

    private Map<String, Object> readableMapToJavaMap(@Nullable ReadableMap map) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (map == null) {
            return result;
        }
        ReadableMapKeySetIterator iterator = map.keySetIterator();
        while (iterator.hasNextKey()) {
            String key = iterator.nextKey();
            result.put(key, toJavaValue(map, key));
        }
        return result;
    }

    private Object numberFromDouble(double value) {
        if (value == Math.rint(value)) {
            long longValue = (long) value;
            if (longValue >= Integer.MIN_VALUE && longValue <= Integer.MAX_VALUE) {
                return (int) longValue;
            }
            return longValue;
        }
        return value;
    }

    @Nullable
    private Object toReactValue(@Nullable Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Boolean || value instanceof String || value instanceof Double || value instanceof Integer) {
            return value;
        }
        if (value instanceof Long || value instanceof Float || value instanceof Short) {
            return ((Number) value).doubleValue();
        }
        if (value instanceof Enum<?>) {
            return ((Enum<?>) value).name();
        }
        if (value instanceof Map<?, ?>) {
            return mapToWritableMap((Map<?, ?>) value);
        }
        if (value instanceof List<?>) {
            return listToWritableArray((List<?>) value);
        }
        if (value.getClass().isArray()) {
            return arrayToWritableArray(value);
        }
        return objectToWritableMap(value);
    }

    private WritableMap objectToWritableMap(Object value) {
        WritableMap map = Arguments.createMap();
        for (Method method : value.getClass().getMethods()) {
            if (method.getParameterTypes().length != 0) {
                continue;
            }
            if (method.getDeclaringClass() == Object.class) {
                continue;
            }
            String propertyName = propertyNameForGetter(method.getName());
            if (propertyName == null) {
                continue;
            }
            try {
                putWritableValue(map, propertyName, method.invoke(value));
            } catch (Exception ignored) {
            }
        }
        return map;
    }

    @Nullable
    private String propertyNameForGetter(String methodName) {
        String baseName;
        if (methodName.startsWith("get") && methodName.length() > 3) {
            baseName = methodName.substring(3);
        } else if (methodName.startsWith("is") && methodName.length() > 2) {
            baseName = methodName.substring(2);
        } else {
            return null;
        }
        return Character.toLowerCase(baseName.charAt(0)) + baseName.substring(1);
    }

    private WritableMap mapToWritableMap(Map<?, ?> source) {
        WritableMap map = Arguments.createMap();
        for (Map.Entry<?, ?> entry : source.entrySet()) {
            if (entry.getKey() == null) {
                continue;
            }
            putWritableValue(map, String.valueOf(entry.getKey()), entry.getValue());
        }
        return map;
    }

    private WritableArray listToWritableArray(List<?> source) {
        WritableArray array = Arguments.createArray();
        for (Object item : source) {
            pushWritableValue(array, item);
        }
        return array;
    }

    private WritableArray arrayToWritableArray(Object source) {
        WritableArray array = Arguments.createArray();
        int length = Array.getLength(source);
        for (int index = 0; index < length; index++) {
            pushWritableValue(array, Array.get(source, index));
        }
        return array;
    }

    private void putWritableValue(WritableMap target, String key, @Nullable Object value) {
        if (value == null) {
            target.putNull(key);
        } else if (value instanceof Boolean) {
            target.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            target.putInt(key, (Integer) value);
        } else if (value instanceof Long || value instanceof Double || value instanceof Float || value instanceof Short) {
            target.putDouble(key, ((Number) value).doubleValue());
        } else if (value instanceof String) {
            target.putString(key, (String) value);
        } else if (value instanceof Enum<?>) {
            target.putString(key, ((Enum<?>) value).name());
        } else if (value instanceof Map<?, ?>) {
            target.putMap(key, mapToWritableMap((Map<?, ?>) value));
        } else if (value instanceof List<?>) {
            target.putArray(key, listToWritableArray((List<?>) value));
        } else if (value.getClass().isArray()) {
            target.putArray(key, arrayToWritableArray(value));
        } else {
            target.putMap(key, objectToWritableMap(value));
        }
    }

    private void pushWritableValue(WritableArray target, @Nullable Object value) {
        if (value == null) {
            target.pushNull();
        } else if (value instanceof Boolean) {
            target.pushBoolean((Boolean) value);
        } else if (value instanceof Integer) {
            target.pushInt((Integer) value);
        } else if (value instanceof Long || value instanceof Double || value instanceof Float || value instanceof Short) {
            target.pushDouble(((Number) value).doubleValue());
        } else if (value instanceof String) {
            target.pushString((String) value);
        } else if (value instanceof Enum<?>) {
            target.pushString(((Enum<?>) value).name());
        } else if (value instanceof Map<?, ?>) {
            target.pushMap(mapToWritableMap((Map<?, ?>) value));
        } else if (value instanceof List<?>) {
            target.pushArray(listToWritableArray((List<?>) value));
        } else if (value.getClass().isArray()) {
            target.pushArray(arrayToWritableArray(value));
        } else {
            target.pushMap(objectToWritableMap(value));
        }
    }

    private interface Operation<P, R> {
        void run(P request, PaymentCallback<R> callback);
    }
}
