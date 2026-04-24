package com.richpayment.sunmipayment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

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
import com.richpayment.sunmipayment.utils.OrderIdGenerator;
import com.richpayment.sunmipayment.utils.SunmiConnectBundle;
import com.sunmi.payment.l3andremoteroutersdk.SunmiPaymentSDKKernel;
import com.sunmi.payment.l3andremoteroutersdk.callback.Callback;
import com.sunmi.payment.l3andremoteroutersdk.callback.ConnectCallback;
import com.sunmi.payment.l3lib.base.BaseBusinessReq;
import com.sunmi.payment.l3lib.base.BaseBusinessResp;
import com.sunmi.payment.l3lib.base.BaseReq;
import com.sunmi.payment.l3lib.base.BaseResp;
import com.sunmi.payment.l3lib.req.BalanceInquiryRequest;
import com.sunmi.payment.l3lib.req.BatchRequest;
import com.sunmi.payment.l3lib.req.CaptureRequest;
import com.sunmi.payment.l3lib.req.CardAuthenticationRequest;
import com.sunmi.payment.l3lib.req.ForceAuthorizationRequest;
import com.sunmi.payment.l3lib.req.IncrementalAuthorizationRequest;
import com.sunmi.payment.l3lib.req.IndependentRefundRequest;
import com.sunmi.payment.l3lib.req.InitRequest;
import com.sunmi.payment.l3lib.req.MerchantInfoRequest;
import com.sunmi.payment.l3lib.req.PinpadRequest;
import com.sunmi.payment.l3lib.req.PreAuthorizationRequest;
import com.sunmi.payment.l3lib.req.PurchaseRequest;
import com.sunmi.payment.l3lib.req.ReadCardRequest;
import com.sunmi.payment.l3lib.req.RefundRequest;
import com.sunmi.payment.l3lib.req.ReprintRequest;
import com.sunmi.payment.l3lib.req.SignatureRequest;
import com.sunmi.payment.l3lib.req.TipAdjustmentRequest;
import com.sunmi.payment.l3lib.req.TransactionCancelRequest;
import com.sunmi.payment.l3lib.req.TransactionHistoryInquiryRequest;
import com.sunmi.payment.l3lib.req.VoidRequest;
import com.sunmi.payment.l3lib.resp.BalanceInquiryResp;
import com.sunmi.payment.l3lib.resp.BatchResp;
import com.sunmi.payment.l3lib.resp.CaptureResp;
import com.sunmi.payment.l3lib.resp.CardAuthenticationResp;
import com.sunmi.payment.l3lib.resp.ForceAuthorizationResp;
import com.sunmi.payment.l3lib.resp.HistoryInquiryResp;
import com.sunmi.payment.l3lib.resp.IndependentRefundResp;
import com.sunmi.payment.l3lib.resp.InitResp;
import com.sunmi.payment.l3lib.resp.IncrementalAuthorizationResp;
import com.sunmi.payment.l3lib.resp.MerchantInfoResp;
import com.sunmi.payment.l3lib.resp.PinpadResp;
import com.sunmi.payment.l3lib.resp.PreAuthorizationResp;
import com.sunmi.payment.l3lib.resp.PurchaseResp;
import com.sunmi.payment.l3lib.resp.ReadCardResp;
import com.sunmi.payment.l3lib.resp.RefundResp;
import com.sunmi.payment.l3lib.resp.ReprintResp;
import com.sunmi.payment.l3lib.resp.SignatureResp;
import com.sunmi.payment.l3lib.resp.TipAdjustmentResp;
import com.sunmi.payment.l3lib.resp.TransactionCancelResp;
import com.sunmi.payment.l3lib.resp.VoidResp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class SunmiPaymentManagerImpl implements SunmiPaymentManager {

    private static final String API_VERSION = "1";
    private static final String SDK_ERROR = "SDK_ERROR";
    private static final String SUCCESS_CODE = "00";

    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final SunmiPaymentSDKKernel kernel;

    SunmiPaymentManagerImpl(Context context) {
        this.kernel = SunmiPaymentSDKKernel.getInstance(context.getApplicationContext());
    }

    @Override
    public void connect(ConnectParams params, Runnable onSuccess, ErrorCallback onError) {
        Bundle bundle = SunmiConnectBundle.build(params);
        try {
            kernel.connect(bundle, new ConnectCallback() {
                @Override
                public void onConnect() {
                    mainHandler.post(onSuccess);
                }

                @Override
                public void onDisconnect(int code, String message) {
                    mainHandler.post(() -> onError.onError(message != null ? message : "Disconnected from payment app (" + code + ")"));
                }

                @Override
                public void onWaitingConnect() {
                }
            });
        } catch (Exception exception) {
            mainHandler.post(() -> onError.onError(exception.getMessage() != null ? exception.getMessage() : "Connection failed"));
        }
    }

    @Override
    public boolean isConnected() {
        return kernel.isConnected();
    }

    @Override
    public void disconnect() {
        kernel.disconnect();
    }

    @Override
    public void init(InitParams params, PaymentCallback<InitResult> callback) {
        String orderId = orderId(params.getOrderId());
        InitRequest request = new InitRequest();
        request.orderId = orderId;
        execute(callback, () -> kernel.init(
                createRequest("init", request),
                createCallback(callback, "init", orderId, (base, response) -> new InitResult(base))
        ));
    }

    @Override
    public void historyInquiry(HistoryInquiryParams params, PaymentCallback<HistoryResult> callback) {
        String orderId = orderId(params.getOrderId());
        TransactionHistoryInquiryRequest request = new TransactionHistoryInquiryRequest();
        request.orderId = orderId;
        execute(callback, () -> kernel.historyInquiry(
                createRequest("transaction_history", request),
                createCallback(callback, "transaction_history", orderId, (base, response) -> new HistoryResult(base, mapHistoryTransactions(response.transList)))
        ));
    }

    @Override
    public void batch(BatchParams params, PaymentCallback<BatchResult> callback) {
        String orderId = orderId(params.getOrderId());
        BatchRequest request = new BatchRequest();
        request.orderId = orderId;
        execute(callback, () -> kernel.batch(
                createRequest("batch_transactions", request),
                createCallback(callback, "batch_transactions", orderId, (base, response) -> new BatchResult(
                        base,
                        response.batchRecordCount,
                        response.batchNetDeposit,
                        response.batchNumber
                ))
        ));
    }

    @Override
    public void getMerchantInfo(MerchantInfoParams params, PaymentCallback<MerchantInfoResult> callback) {
        String orderId = orderId(params.getOrderId());
        MerchantInfoRequest request = new MerchantInfoRequest();
        request.orderId = orderId;
        execute(callback, () -> kernel.getMerchantInfo(
                createRequest("get_merchant_infos", request),
                createCallback(callback, "get_merchant_infos", orderId, (base, response) -> new MerchantInfoResult(
                        base,
                        response.merchantName,
                        response.terminalID,
                        response.merchantNumber,
                        response.address,
                        response.city,
                        response.state,
                        response.zipCode,
                        response.phone,
                        response.currencyCode
                ))
        ));
    }

    @Override
    public void purchase(PurchaseParams params, PaymentCallback<PurchaseResult> callback) {
        String orderId = orderId(params.getOrderId());
        PurchaseRequest request = new PurchaseRequest();
        request.orderId = orderId;
        request.paymentType = params.getPaymentType().getValue();
        request.amount = params.getAmount();
        request.currency = params.getCurrency();
        if (params.getTip() != null) {
            request.tip = params.getTip();
        }
        if (params.getTax() != null) {
            request.tax = params.getTax();
        }
        if (params.getSurcharge() != null) {
            request.surcharge = params.getSurcharge();
        }
        execute(callback, () -> kernel.purchase(
                createRequest("purchase", request),
                createCallback(callback, "purchase", orderId, (base, response) -> new PurchaseResult(
                        base,
                        response.approvedAmount,
                        response.approvedTax,
                        response.approvedTip,
                        response.approvedSurcharge,
                        response.cardType,
                        response.cardName,
                        response.maskedPan,
                        response.transactionId,
                        response.approvalCode,
                        response.retrievalReferenceNum,
                        response.cvmResult
                ))
        ));
    }

    @Override
    public void void_(VoidParams params, PaymentCallback<VoidResult> callback) {
        String orderId = orderId(params.getOrderId());
        VoidRequest request = new VoidRequest();
        request.orderId = orderId;
        request.voidType = params.getVoidType().getValue();
        request.oriOrderId = params.getOriOrderId();
        request.oriTransactionID = params.getOriTransactionId();
        request.oriApprovalCode = params.getOriApprovalCode();
        request.oriRetrievalReferenceNum = params.getOriRetrievalReferenceNum();
        if (params.getAmount() != null) {
            request.amount = params.getAmount();
        }
        execute(callback, () -> kernel.void_(
                createRequest("void", request),
                createCallback(callback, "void", orderId, (base, response) -> new VoidResult(
                        base,
                        response.approvedAmount,
                        response.approvedTax,
                        response.approvedTip,
                        response.approvedSurcharge,
                        null,
                        null,
                        response.maskedPan,
                        response.transactionId,
                        response.approvalCode,
                        response.retrievalReferenceNum,
                        null
                ))
        ));
    }

    @Override
    public void independentRefund(IndependentRefundParams params, PaymentCallback<IndependentRefundResult> callback) {
        String orderId = orderId(params.getOrderId());
        IndependentRefundRequest request = new IndependentRefundRequest();
        request.orderId = orderId;
        request.refundType = params.getRefundType().getValue();
        request.amount = params.getAmount();
        request.currency = params.getCurrency();
        execute(callback, () -> kernel.independentRefund(
                createRequest("independent_refund", request),
                createCallback(callback, "independent_refund", orderId, (base, response) -> new IndependentRefundResult(
                        base,
                        response.approvedAmount,
                        response.transactionId,
                        response.approvalCode,
                        response.retrievalReferenceNum,
                        response.cvmResult
                ))
        ));
    }

    @Override
    public void refund(RefundParams params, PaymentCallback<RefundResult> callback) {
        String orderId = orderId(params.getOrderId());
        RefundRequest request = new RefundRequest();
        request.orderId = orderId;
        request.oriOrderId = params.getOriOrderId();
        request.oriTransactionID = params.getOriTransactionId();
        request.oriApprovalCode = params.getOriApprovalCode();
        request.oriRetrievalReferenceNum = params.getOriRetrievalReferenceNum();
        execute(callback, () -> kernel.refund(
                createRequest("refund", request),
                createCallback(callback, "refund", orderId, (base, response) -> new RefundResult(
                        base,
                        response.approvedAmount,
                        response.transactionId,
                        response.approvalCode,
                        response.retrievalReferenceNum,
                        null
                ))
        ));
    }

    @Override
    public void preAuthorization(PreAuthParams params, PaymentCallback<PreAuthResult> callback) {
        String orderId = orderId(params.getOrderId());
        PreAuthorizationRequest request = new PreAuthorizationRequest();
        request.orderId = orderId;
        request.amount = params.getAmount();
        request.currency = params.getCurrency();
        if (params.getTax() != null) {
            request.tax = params.getTax();
        }
        execute(callback, () -> kernel.preAuthorization(
                createRequest("pre_authorization", request),
                createCallback(callback, "pre_authorization", orderId, (base, response) -> new PreAuthResult(
                        base,
                        response.approvedAmount,
                        response.approvedTax,
                        null,
                        null,
                        response.cardType,
                        response.cardName,
                        response.maskedPan,
                        response.transactionId,
                        response.approvalCode,
                        response.retrievalReferenceNum,
                        response.cvmResult
                ))
        ));
    }

    @Override
    public void capture(CaptureParams params, PaymentCallback<CaptureResult> callback) {
        String orderId = orderId(params.getOrderId());
        CaptureRequest request = new CaptureRequest();
        request.orderId = orderId;
        request.amount = params.getAmount();
        request.currency = params.getCurrency();
        request.oriOrderId = params.getOriOrderId();
        request.oriTransactionID = params.getOriTransactionId();
        request.oriApprovalCode = params.getOriApprovalCode();
        request.oriRetrievalReferenceNum = params.getOriRetrievalReferenceNum();
        if (params.getTip() != null) {
            request.tip = params.getTip();
        }
        if (params.getSurcharge() != null) {
            request.surcharge = params.getSurcharge();
        }
        if (params.getTax() != null) {
            request.tax = params.getTax();
        }
        execute(callback, () -> kernel.capture(
                createRequest("capture", request),
                createCallback(callback, "capture", orderId, (base, response) -> new CaptureResult(
                        base,
                        response.approvedAmount,
                        response.approvedTax,
                        response.approvedTip,
                        response.approvedSurcharge,
                        response.cardType,
                        response.cardName,
                        response.maskedPan,
                        response.oriTransactionId,
                        response.oriApprovalCode,
                        response.oriRetrievalReferenceNum,
                        null
                ))
        ));
    }

    @Override
    public void forceAuthorization(ForceAuthParams params, PaymentCallback<ForceAuthResult> callback) {
        String orderId = orderId(params.getOrderId());
        ForceAuthorizationRequest request = new ForceAuthorizationRequest();
        request.orderId = orderId;
        request.amount = params.getAmount();
        request.currency = params.getCurrency();
        if (params.getTax() != null) {
            request.tax = params.getTax();
        }
        if (params.getSurcharge() != null) {
            request.surcharge = params.getSurcharge();
        }
        execute(callback, () -> kernel.forceAuthorization(
                createRequest("force_auth", request),
                createCallback(callback, "force_auth", orderId, (base, response) -> new ForceAuthResult(
                        base,
                        response.approvedAmount,
                        response.approvedTax,
                        null,
                        response.approvedSurcharge,
                        response.cardType,
                        response.cardName,
                        response.maskedPan,
                        response.transactionId,
                        response.approvalCode,
                        null,
                        null
                ))
        ));
    }

    @Override
    public void tipAdjustment(TipAdjustmentParams params, PaymentCallback<TransactionResult> callback) {
        String orderId = orderId(params.getOrderId());
        TipAdjustmentRequest request = new TipAdjustmentRequest();
        request.orderId = orderId;
        request.oriOrderId = params.getOriOrderId();
        request.oriTransactionID = params.getOriTransactionId();
        request.oriApprovalCode = params.getOriApprovalCode();
        request.oriRetrievalReferenceNum = params.getOriRetrievalReferenceNum();
        request.amount = params.getTipAmount();
        execute(callback, () -> kernel.tipAdjustment(
                createRequest("tip_adjustment", request),
                createCallback(callback, "tip_adjustment", orderId, (base, response) -> new TransactionResult(
                        base,
                        null,
                        null,
                        response.approvedTip,
                        null,
                        null,
                        null,
                        null,
                        response.oriTransactionId,
                        response.oriApprovalCode,
                        response.oriRetrievalReferenceNum,
                        null
                ))
        ));
    }

    @Override
    public void incrementalAuthorization(IncrementalAuthParams params, PaymentCallback<IncrementalAuthResult> callback) {
        String orderId = orderId(params.getOrderId());
        IncrementalAuthorizationRequest request = new IncrementalAuthorizationRequest();
        request.orderId = orderId;
        request.amount = params.getAmount();
        request.currency = params.getCurrency();
        request.oriOrderId = params.getOriOrderId();
        request.oriTransactionID = params.getOriTransactionId();
        request.oriApprovalCode = params.getOriApprovalCode();
        request.oriRetrievalReferenceNum = params.getOriRetrievalReferenceNum();
        execute(callback, () -> kernel.incrementalAuthorization(
                createRequest("incremental_auth", request),
                createCallback(callback, "incremental_auth", orderId, (base, response) -> new IncrementalAuthResult(
                        base,
                        response.approvedAmount,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        response.transactionId,
                        response.approvalCode,
                        response.retrievalReferenceNum,
                        null
                ))
        ));
    }

    @Override
    public void cardAuthentication(CardAuthParams params, PaymentCallback<CardAuthResult> callback) {
        String orderId = orderId(params.getOrderId());
        CardAuthenticationRequest request = new CardAuthenticationRequest();
        request.orderId = orderId;
        execute(callback, () -> kernel.cardAuthentication(
                createRequest("card_authentication", request),
                createCallback(callback, "card_authentication", orderId, (base, response) -> new CardAuthResult(
                        base,
                        null,
                        null,
                        null,
                        null,
                        response.cardType,
                        response.cardName,
                        response.maskedPan,
                        response.transactionId,
                        response.approvalCode,
                        response.retrievalReferenceNum,
                        null
                ))
        ));
    }

    @Override
    public void balanceInquiry(BalanceInquiryParams params, PaymentCallback<BalanceResult> callback) {
        String orderId = orderId(params.getOrderId());
        BalanceInquiryRequest request = new BalanceInquiryRequest();
        request.orderId = orderId;
        execute(callback, () -> kernel.balanceInquiry(
                createRequest("balance_inquiry", request),
                createCallback(callback, "balance_inquiry", orderId, (base, response) -> new BalanceResult(base, response.amount))
        ));
    }

    @Override
    public void transactionCancel(TransactionCancelParams params, PaymentCallback<BaseResult> callback) {
        String orderId = orderId(params.getOrderId());
        TransactionCancelRequest request = new TransactionCancelRequest();
        request.orderId = orderId;
        execute(callback, () -> kernel.transactionCancel(
                createRequest("cancel_transaction", request),
                createCallback(callback, "cancel_transaction", orderId, (base, response) -> base)
        ));
    }

    @Override
    public void applySignature(SignatureParams params, PaymentCallback<SignatureResult> callback) {
        String orderId = orderId(params.getOrderId());
        SignatureRequest request = new SignatureRequest();
        request.orderId = orderId;
        request.oriOrderId = params.getOriOrderId();
        request.oriTransactionID = params.getOriTransactionId();
        request.oriApprovalCode = params.getOriApprovalCode();
        request.oriRetrievalReferenceNum = params.getOriRetrievalReferenceNum();
        execute(callback, () -> kernel.applySignature(
                createRequest("apply_signature", request),
                createCallback(callback, "apply_signature", orderId, (base, response) -> new SignatureResult(base, response.signature, response.oriOrderId))
        ));
    }

    @Override
    public void getSignature(SignatureParams params, PaymentCallback<SignatureResult> callback) {
        String orderId = orderId(params.getOrderId());
        SignatureRequest request = new SignatureRequest();
        request.orderId = orderId;
        request.oriOrderId = params.getOriOrderId();
        request.oriTransactionID = params.getOriTransactionId();
        request.oriApprovalCode = params.getOriApprovalCode();
        request.oriRetrievalReferenceNum = params.getOriRetrievalReferenceNum();
        execute(callback, () -> kernel.getSignature(
                createRequest("get_signature", request),
                createCallback(callback, "get_signature", orderId, (base, response) -> new SignatureResult(base, response.signature, response.oriOrderId))
        ));
    }

    @Override
    public void reprint(ReprintParams params, PaymentCallback<BaseResult> callback) {
        String orderId = orderId(params.getOrderId());
        ReprintRequest request = new ReprintRequest();
        request.orderId = orderId;
        request.oriOrderId = params.getOriOrderId();
        request.oriTransactionID = params.getOriTransactionId();
        request.oriApprovalCode = params.getOriApprovalCode();
        request.oriRetrievalReferenceNum = params.getOriRetrievalReferenceNum();
        execute(callback, () -> kernel.reprint(
                createRequest("reprint", request),
                createCallback(callback, "reprint", orderId, (base, response) -> base)
        ));
    }

    @Override
    public void readCard(ReadCardParams params, PaymentCallback<ReadCardResult> callback) {
        String orderId = orderId(params.getOrderId());
        ReadCardRequest request = new ReadCardRequest();
        request.orderId = orderId;
        request.readCardTypes = params.getReadCardTypes();
        request.timeout = params.getTimeout();
        execute(callback, () -> kernel.readCard(
                createRequest("read_card", request),
                createCallback(callback, "read_card", orderId, (base, response) -> new ReadCardResult(
                        base,
                        response.track1,
                        response.track2,
                        response.track3,
                        response.cardNumber,
                        response.cardExpiredDate,
                        response.cardServiceCode,
                        response.cardHolderName
                ))
        ));
    }

    @Override
    public void pinPad(PinpadParams params, PaymentCallback<PinpadResult> callback) {
        String orderId = orderId(params.getOrderId());
        PinpadRequest request = new PinpadRequest();
        request.orderId = orderId;
        request.timeout = params.getTimeout();
        execute(callback, () -> kernel.pinPad(
                createRequest("pinpad", request),
                createCallback(callback, "pinpad", orderId, (base, response) -> new PinpadResult(base, response.ciphertextPin, response.ciphertextKSN))
        ));
    }

    private <T extends BaseBusinessReq> BaseReq<T> createRequest(String action, T request) {
        BaseReq<T> baseReq = new BaseReq<>();
        baseReq.apiVersion = API_VERSION;
        baseReq.dataTimestamp = OrderIdGenerator.getCurrentTimestamp();
        baseReq.action = action;
        baseReq.request = request;
        return baseReq;
    }

    private <R> void execute(PaymentCallback<R> callback, Runnable action) {
        try {
            action.run();
        } catch (Exception exception) {
            postError(callback, SDK_ERROR, exception.getMessage() != null ? exception.getMessage() : "Unknown SDK error");
        }
    }

    private <T extends BaseBusinessResp, R> Callback<T> createCallback(
            PaymentCallback<R> callback,
            String action,
            String fallbackOrderId,
            ResultMapper<T, R> mapper
    ) {
        return new Callback<T>() {
            @Override
            public void onResponse(BaseResp<T> response) {
                mainHandler.post(() -> handleResponse(response, callback, action, fallbackOrderId, mapper));
            }
        };
    }

    private <T extends BaseBusinessResp, R> void handleResponse(
            BaseResp<T> response,
            PaymentCallback<R> callback,
            String action,
            String fallbackOrderId,
            ResultMapper<T, R> mapper
    ) {
        if (response == null) {
            callback.onError(SDK_ERROR, "Empty SDK response");
            return;
        }

        boolean hasEvent = response.eventCode != 0 || response.eventData != null;
        if (hasEvent) {
            callback.onEvent(response.eventCode, response.eventData);
        }

        T businessResponse = response.response;
        if (businessResponse == null) {
            if (!hasEvent) {
                callback.onError(SDK_ERROR, "Empty SDK response body");
            }
            return;
        }

        if (hasEvent && isBlank(businessResponse.resultCode)) {
            return;
        }

        BaseResult base = new BaseResult(
                businessResponse.orderId != null ? businessResponse.orderId : fallbackOrderId,
                businessResponse.resultCode != null ? businessResponse.resultCode : "",
                businessResponse.resultMsg != null ? businessResponse.resultMsg : "",
                response.eventCode,
                action
        );

        if (SUCCESS_CODE.equals(base.getResultCode())) {
            callback.onSuccess(mapper.map(base, businessResponse));
        } else {
            callback.onError(base.getResultCode(), base.getResultMsg());
        }
    }

    private String orderId(String providedOrderId) {
        return providedOrderId != null ? providedOrderId : OrderIdGenerator.generate();
    }

    private <R> void postError(PaymentCallback<R> callback, String code, String message) {
        mainHandler.post(() -> callback.onError(code, message));
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private List<Map<String, Object>> mapHistoryTransactions(List<?> transactions) {
        List<Map<String, Object>> mapped = new ArrayList<>();
        if (transactions == null) {
            return mapped;
        }
        for (Object transaction : transactions) {
            if (transaction == null) {
                continue;
            }
            Map<String, Object> item = new LinkedHashMap<>();
            put(item, "tranType", readField(transaction, "tranType"));
            put(item, "currency", readField(transaction, "currency"));
            put(item, "approvedAmount", readField(transaction, "approvedAmount"));
            put(item, "approvedTip", readField(transaction, "approvedTip"));
            put(item, "approvedSurcharge", readField(transaction, "approvedSurcharge"));
            put(item, "approvedTax", readField(transaction, "approvedTax"));
            put(item, "approvedMerchantFee", readField(transaction, "approvedMerchantFee"));
            put(item, "approvedCashback", readField(transaction, "approvedCashback"));
            put(item, "transactionId", readField(transaction, "transactionId"));
            put(item, "approvalCode", readField(transaction, "approvalCode"));
            put(item, "retrievalReferenceNum", readField(transaction, "retrievalReferenceNum"));
            put(item, "cardType", readField(transaction, "cardType"));
            put(item, "cardName", readField(transaction, "cardName"));
            put(item, "maskedPan", readField(transaction, "maskedPan"));
            put(item, "voidReason", readField(transaction, "voidReason"));
            put(item, "respCode", readField(transaction, "respCode"));
            put(item, "respMsg", readField(transaction, "respMsg"));
            put(item, "isSettlemented", readField(transaction, "isSettlemented"));
            mapped.add(item);
        }
        return mapped;
    }

    private void put(Map<String, Object> target, String key, Object value) {
        target.put(key, value);
    }

    private Object readField(Object source, String fieldName) {
        try {
            Field field = source.getClass().getField(fieldName);
            return field.get(source);
        } catch (Exception ignored) {
            return null;
        }
    }

    private interface ResultMapper<T extends BaseBusinessResp, R> {
        R map(BaseResult base, T response);
    }
}
