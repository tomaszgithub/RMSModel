package com.reporting.mocks.model.trade.OtcTradeTypes;

import com.reporting.mocks.model.trade.OtcTrade;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.OtcUnderlying;

import java.util.Date;
import java.util.Random;

public class Spot extends OtcTrade {
    protected Date settlementDate;
    protected Double rate;
    protected Double amountCcy1;
    protected Double amountCcy2;

    public Spot(OtcUnderlying underlying,
                Date settlementDate,
                Double rate,
                Double amountCcy1,
                Double amountCcy2,
                String book) {
        super(TradeType.Spot, underlying, book);
        this.settlementDate = settlementDate;
        this.rate = rate;
        this.amountCcy1 = amountCcy1;
        this.amountCcy2 = amountCcy2;
    }

    public Spot(Spot fxSpot) {
        super(fxSpot);
        this.settlementDate = fxSpot.settlementDate;
        this.rate = fxSpot.rate;
        this.amountCcy1 = fxSpot.amountCcy1;
        this.amountCcy2 = fxSpot.amountCcy2;
    }

    public Date getSettlementDate() {
        return settlementDate;
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

    @Override
    public OtcUnderlying getUnderlying() {
        return super.getUnderlying();
    }

    @Override
    public Spot createNewVersion() {
        return new Spot(this);
    }
}
