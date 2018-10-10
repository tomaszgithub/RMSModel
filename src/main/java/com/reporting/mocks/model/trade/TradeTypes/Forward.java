package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;

public class Forward extends Trade {
    protected Underlying underlying2;
    protected Date settlementDate;
    protected Double price;

    public Forward(String book,
                   Double quantity,
                   Underlying underlying1,
                   Underlying underlying2,
                   Date settlementDate,
                   Double price) {
        super(TradeKind.Any, TradeType.Forward, book, quantity, underlying1);
        this.underlying2 = underlying2;
        this.settlementDate = settlementDate;
        this.price = price;
    }

    public Forward(Forward forward) {
        super(forward);
        this.underlying2 = forward.underlying2;
        this.settlementDate = forward.settlementDate;
        this.price = forward.price;
    }


    @Override
    public Forward createNewVersion() {
        return new Forward(this);
    }

    public Underlying getUnderlying2() {
        return underlying2;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAmount1() {
        return this.quantity;
    }

    public Double getAmount2() {
        return this.quantity * this.price * -1;
    }
}
