package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.*;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;

public class Payment extends Trade {
    protected final String settlementDate = "settlementDate";

    public Payment() {
        super();
    }

    protected Payment(
            String book,
            Tcn tcn,
            Double underlyingAmount1,
            Underlying underlying1,
            Date settlementDate
    ) {
        super(TradeKind.Any, TradeType.Payment, tcn, book, underlyingAmount1, underlying1);
        this.assignAttribute(this.settlementDate, settlementDate);
    }

    public Payment(String book, Double underlyingAmount1, Underlying underlying1, Date settlementDate) {
        this(book, new Tcn(), underlyingAmount1, underlying1, settlementDate);
    }

    public Payment(Payment payment) {
        this(payment.getBook(), payment.getUnderlying1Amount(), payment.getUnderlying1(), payment.getSettlementDate());
    }

    @Override
    public Payment createNewVersion() {
        return new Payment(this.getBook(),
                this.getTcn().createNewVersion(),
                this.getUnderlying1Amount(),
                this.getUnderlying1(),
                this.getSettlementDate());
    }

    public Date getSettlementDate() {
        return (Date)this.retreiveAttribute(this.settlementDate);
    }
}
