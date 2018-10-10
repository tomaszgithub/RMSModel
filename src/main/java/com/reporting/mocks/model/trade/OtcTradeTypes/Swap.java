package com.reporting.mocks.model.trade.OtcTradeTypes;

import com.reporting.mocks.model.trade.OtcTrade;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.OtcUnderlying;

import java.util.Date;

public class Swap extends OtcTrade {
    protected Date nearSettlementDate;
    protected Date farSettlementDate;
    protected Double rate;
    protected Double amountCcy1;
    protected Double amountCcy2;

    public Swap(
            OtcUnderlying underlying,
            Date nearSettlementDate,
            Date farSettlementDate,
            Double rate,
            Double amountCcy1,
            Double amountCcy2,
            String book) {
        super(TradeType.Swap, underlying, book);
        this.nearSettlementDate = nearSettlementDate;
        this.farSettlementDate = farSettlementDate;
        this.rate = rate;
        this.amountCcy1 = amountCcy1;
        this.amountCcy2 = amountCcy2;
    }

    public Swap(Swap swap) {
        super(swap);
        this.nearSettlementDate = swap.nearSettlementDate;
        this.farSettlementDate = swap.farSettlementDate;
        this.rate = swap.rate;
        this.amountCcy1 = swap.amountCcy1;
        this.amountCcy2 = swap.amountCcy2;
    }

    @Override
    public OtcTrade createNewVersion() {
        return new Swap(this);
    }

    public Date getNearSettlementDate() {
        return nearSettlementDate;
    }

    public Date getFarSettlementDate() {
        return farSettlementDate;
    }

    public Double getRate() {
        return rate;
    }

    public Double getAmountCcy1() {
        return amountCcy1;
    }

    public Double getAmountCcy2() {
        return amountCcy2;
    }
}
