package com.richpayment.sunmipayment;

import android.content.Context;

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

public interface SunmiPaymentManager {

    void connect(ConnectParams params, Runnable onSuccess, ErrorCallback onError);

    boolean isConnected();

    void disconnect();

    void init(InitParams params, PaymentCallback<InitResult> callback);

    void historyInquiry(HistoryInquiryParams params, PaymentCallback<HistoryResult> callback);

    void batch(BatchParams params, PaymentCallback<BatchResult> callback);

    void getMerchantInfo(MerchantInfoParams params, PaymentCallback<MerchantInfoResult> callback);

    void purchase(PurchaseParams params, PaymentCallback<PurchaseResult> callback);

    void void_(VoidParams params, PaymentCallback<VoidResult> callback);

    void independentRefund(IndependentRefundParams params, PaymentCallback<IndependentRefundResult> callback);

    void refund(RefundParams params, PaymentCallback<RefundResult> callback);

    void preAuthorization(PreAuthParams params, PaymentCallback<PreAuthResult> callback);

    void capture(CaptureParams params, PaymentCallback<CaptureResult> callback);

    void forceAuthorization(ForceAuthParams params, PaymentCallback<ForceAuthResult> callback);

    void tipAdjustment(TipAdjustmentParams params, PaymentCallback<TransactionResult> callback);

    void incrementalAuthorization(IncrementalAuthParams params, PaymentCallback<IncrementalAuthResult> callback);

    void cardAuthentication(CardAuthParams params, PaymentCallback<CardAuthResult> callback);

    void balanceInquiry(BalanceInquiryParams params, PaymentCallback<BalanceResult> callback);

    void transactionCancel(TransactionCancelParams params, PaymentCallback<BaseResult> callback);

    void applySignature(SignatureParams params, PaymentCallback<SignatureResult> callback);

    void getSignature(SignatureParams params, PaymentCallback<SignatureResult> callback);

    void reprint(ReprintParams params, PaymentCallback<BaseResult> callback);

    void readCard(ReadCardParams params, PaymentCallback<ReadCardResult> callback);

    void pinPad(PinpadParams params, PaymentCallback<PinpadResult> callback);

    static SunmiPaymentManager create(Context context) {
        return new SunmiPaymentManagerImpl(context.getApplicationContext());
    }

    interface ErrorCallback {
        void onError(String message);
    }
}
