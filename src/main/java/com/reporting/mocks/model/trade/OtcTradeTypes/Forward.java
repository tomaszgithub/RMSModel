package com.reporting.mocks.model.trade.OtcTradeTypes;

import com.reporting.mocks.model.trade.OtcTrade;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.OtcUnderlying;

import java.util.Date;

public class Forward extends OtcTrade {
    protected Date settlementDate;
    protected Double rate;
    protected Double amountCcy1;
    protected Double amountCcy2;

    public Forward(
                OtcUnderlying underlying,
                Date settlementDate,
                Double rate,
                Double amountCcy1,
                Double amountCcy2,
                String book) {
        super(TradeType.Forward, underlying, book);
        this.settlementDate = settlementDate;
        this.rate = rate;
        this.amountCcy1 = amountCcy1;
        this.amountCcy2 = amountCcy2;
    }

    public Forward(Forward forward) {
        super(forward);
        this.settlementDate = forward.settlementDate;
        this.rate = forward.rate;
        this.amountCcy1 = forward.amountCcy1;
        this.amountCcy2 = forward.amountCcy2;
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
    public OtcTrade createNewVersion() {
        return new Forward(this);
    }
}
