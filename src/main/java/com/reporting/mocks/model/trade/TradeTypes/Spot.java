package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;

public class Spot extends Trade {
    protected Underlying underlying2;
    protected Date settlementDate;
    protected Double price;

    public Spot(String book, Double quantity, Underlying underlying1, Underlying underlying2, Date settlementDate, Double price) {
        super(TradeKind.Any, TradeType.Spot, book, quantity, underlying1);
        this.underlying2 = underlying2;
        this.settlementDate = settlementDate;
        this.price = price;
    }

    public Spot(Spot spot) {
        super(spot);
        this.underlying2 = spot.underlying2;
        this.settlementDate = spot.settlementDate;
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

    @Override
    public Spot createNewVersion() {
        return new Spot(this);
    }
}
