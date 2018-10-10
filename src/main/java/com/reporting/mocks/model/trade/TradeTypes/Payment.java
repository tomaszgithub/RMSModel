package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.*;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;

public class Payment extends Trade {
    protected Date settlementDate;


    public Payment(String book, Double quantity, Underlying underlying1, Date settlementDate) {
        super(TradeKind.Any, TradeType.Payment, book, quantity, underlying1);
        this.settlementDate = settlementDate;
    }

    public Payment(Payment payment) {
        super(payment);
    }

    @Override
    public Payment createNewVersion() {
        return new Payment(this);
    }

    public Date getSettlementDate() {
        return settlementDate;
    }
}
