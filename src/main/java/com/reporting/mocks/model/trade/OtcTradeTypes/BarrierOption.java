package com.reporting.mocks.model.trade.OtcTradeTypes;

import com.reporting.mocks.model.trade.OtcTrade;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.OtcUnderlying;

import java.util.Date;

public class BarrierOption extends OtcTrade {
    protected Date expiryDate;
    protected Double strike;
    protected Double barrier;
    protected Double amountCcy1;
    protected Double amountCcy2;

    public BarrierOption(OtcUnderlying underlying,
                         Date expiryDate,
                         Double strike,
                         Double barrier,
                         Double amountCcy1,
                         Double amountCcy2,
                         String book) {
        super(TradeType.BarrierOption, underlying, book);
        this.expiryDate = expiryDate;
        this.strike = strike;
        this.barrier = barrier;
        this.amountCcy1 = amountCcy1;
        this.amountCcy2 = amountCcy2;
    }

    public BarrierOption(BarrierOption barrierOption) {
        super(barrierOption);
        this.expiryDate = barrierOption.expiryDate;
        this.strike = barrierOption.strike;
        this.barrier = barrierOption.barrier;
        this.amountCcy1 = barrierOption.amountCcy1;
        this.amountCcy2 = barrierOption.amountCcy2;
    }

    @Override
    public OtcTrade createNewVersion() {
        return new BarrierOption(this);
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Double getStrike() {
        return strike;
    }

    public Double getBarrier() {
        return barrier;
    }

    public Double getAmountCcy1() {
        return amountCcy1;
    }

    public Double getAmountCcy2() {
        return amountCcy2;
    }
}
