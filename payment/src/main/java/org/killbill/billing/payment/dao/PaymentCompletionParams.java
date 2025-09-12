package org.killbill.billing.payment.dao;

import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.Nullable;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.TransactionStatus;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.callcontext.InternalCallContext;

/**
 * Param object to update payment and transaction atomically on completion.
 */
public class PaymentCompletionParams {

    public final UUID accountId;
    @Nullable public final UUID attemptId;
    public final UUID paymentId;
    public final TransactionType transactionType;
    public final String currentPaymentStateName;
    @Nullable public final String lastPaymentSuccessStateName;
    public final UUID transactionId;
    public final TransactionStatus paymentStatus;
    public final BigDecimal processedAmount;
    public final Currency processedCurrency;
    @Nullable public final String gatewayErrorCode;
    @Nullable public final String gatewayErrorMsg;
    public final boolean isApiPayment;
    public final InternalCallContext context;

    private PaymentCompletionParams(Builder b) {
        this.accountId = b.accountId;
        this.attemptId = b.attemptId;
        this.paymentId = b.paymentId;
        this.transactionType = b.transactionType;
        this.currentPaymentStateName = b.currentPaymentStateName;
        this.lastPaymentSuccessStateName = b.lastPaymentSuccessStateName;
        this.transactionId = b.transactionId;
        this.paymentStatus = b.paymentStatus;
        this.processedAmount = b.processedAmount;
        this.processedCurrency = b.processedCurrency;
        this.gatewayErrorCode = b.gatewayErrorCode;
        this.gatewayErrorMsg = b.gatewayErrorMsg;
        this.isApiPayment = b.isApiPayment;
        this.context = b.context;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UUID accountId;
        private UUID attemptId;
        private UUID paymentId;
        private TransactionType transactionType;
        private String currentPaymentStateName;
        private String lastPaymentSuccessStateName;
        private UUID transactionId;
        private TransactionStatus paymentStatus;
        private BigDecimal processedAmount;
        private Currency processedCurrency;
        private String gatewayErrorCode;
        private String gatewayErrorMsg;
        private boolean isApiPayment;
        private InternalCallContext context;

        public Builder accountId(UUID v) { this.accountId = v; return this; }
        public Builder attemptId(UUID v) { this.attemptId = v; return this; }
        public Builder paymentId(UUID v) { this.paymentId = v; return this; }
        public Builder transactionType(TransactionType v) { this.transactionType = v; return this; }
        public Builder currentState(String v) { this.currentPaymentStateName = v; return this; }
        public Builder lastSuccessState(String v) { this.lastPaymentSuccessStateName = v; return this; }
        public Builder transactionId(UUID v) { this.transactionId = v; return this; }
        public Builder status(TransactionStatus v) { this.paymentStatus = v; return this; }
        public Builder processedAmount(BigDecimal v) { this.processedAmount = v; return this; }
        public Builder processedCurrency(Currency v) { this.processedCurrency = v; return this; }
        public Builder gatewayErrorCode(String v) { this.gatewayErrorCode = v; return this; }
        public Builder gatewayErrorMsg(String v) { this.gatewayErrorMsg = v; return this; }
        public Builder apiPayment(boolean v) { this.isApiPayment = v; return this; }
        public Builder context(InternalCallContext v) { this.context = v; return this; }

        public PaymentCompletionParams build() {
            return new PaymentCompletionParams(this);
        }
    }
}