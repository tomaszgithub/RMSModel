package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;

public class Swap extends Trade {
    protected Underlying underlying2;
    protected Date nearSettlementDate;
    protected Date farSettlementDate;
    protected Double price;

    public Swap(
            String book,
            Double quantity,
            Underlying underlying1,
            Underlying underlying2,
            Date nearSettlementDate,
            Date farSettlementDate,
            Double price
            ) {
        super(TradeKind.Any, TradeType.Swap, book, quantity, underlying1);
        this.underlying2 = underlying2;
        this.nearSettlementDate = nearSettlementDate;
        this.farSettlementDate = farSettlementDate;
        this.price = price;
    }

    public Swap(Swap swap) {
        super(swap);
        this.underlying2 = swap.underlying2;
        this.nearSettlementDate = swap.nearSettlementDate;
        this.farSettlementDate = swap.farSettlementDate;
        this.price = swap.price;
    }

    @Override
    public Swap createNewVersion() {
        return new Swap(this);
    }

    public Underlying getUnderlying2() {
        return underlying2;
    }

    public Date getNearSettlementDate() {
        return nearSettlementDate;
    }

    public Date getFarSettlementDate() {
        return farSettlementDate;
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
