"use strict";

const { NativeEventEmitter, NativeModules, Platform } = require("react-native");

const LINKING_ERROR =
  "The package '@richpaymentsolutions/react-native-sunmi-payment' is not linked. " +
  "Reinstall dependencies, run CocoaPods if you add iOS later, and rebuild the app.";

const EVENT_NAME = "SunmiPaymentEvent";
const nativeModule = NativeModules.SunmiPayment;
const eventEmitter =
  Platform.OS === "android" && nativeModule
    ? new NativeEventEmitter(nativeModule)
    : null;

const SunmiPayment = nativeModule
  ? nativeModule
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

function ensureEventEmitter() {
  if (eventEmitter) {
    return eventEmitter;
  }

  throw new Error(LINKING_ERROR);
}

function withOptionalParams(methodName, params) {
  return params == null ? SunmiPayment[methodName](null) : SunmiPayment[methodName](params);
}

function addSunmiPaymentListener(listener) {
  return ensureEventEmitter().addListener(EVENT_NAME, listener);
}

function removeAllSunmiPaymentListeners() {
  ensureEventEmitter().removeAllListeners(EVENT_NAME);
}

module.exports = {
  EVENT_NAME,
  SunmiPayment: {
    connect: params => withOptionalParams("connect", params),
    disconnect: () => SunmiPayment.disconnect(),
    isConnected: () => SunmiPayment.isConnected(),
    init: params => withOptionalParams("init", params),
    historyInquiry: params => withOptionalParams("historyInquiry", params),
    batch: params => withOptionalParams("batch", params),
    getMerchantInfo: params => withOptionalParams("getMerchantInfo", params),
    purchase: params => withOptionalParams("purchase", params),
    voidTransaction: params => withOptionalParams("voidTransaction", params),
    independentRefund: params => withOptionalParams("independentRefund", params),
    refund: params => withOptionalParams("refund", params),
    preAuthorization: params => withOptionalParams("preAuthorization", params),
    capture: params => withOptionalParams("capture", params),
    forceAuthorization: params => withOptionalParams("forceAuthorization", params),
    tipAdjustment: params => withOptionalParams("tipAdjustment", params),
    incrementalAuthorization: params =>
      withOptionalParams("incrementalAuthorization", params),
    cardAuthentication: params => withOptionalParams("cardAuthentication", params),
    balanceInquiry: params => withOptionalParams("balanceInquiry", params),
    transactionCancel: params => withOptionalParams("transactionCancel", params),
    applySignature: params => withOptionalParams("applySignature", params),
    getSignature: params => withOptionalParams("getSignature", params),
    reprint: params => withOptionalParams("reprint", params),
    readCard: params => withOptionalParams("readCard", params),
    pinPad: params => withOptionalParams("pinPad", params),
    addListener: addSunmiPaymentListener,
    removeAllListeners: removeAllSunmiPaymentListeners,
  },
  addSunmiPaymentListener,
  removeAllSunmiPaymentListeners,
};

module.exports.default = module.exports.SunmiPayment;
