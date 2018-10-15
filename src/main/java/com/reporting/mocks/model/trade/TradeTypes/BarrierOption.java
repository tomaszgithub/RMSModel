package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;

public class BarrierOption extends Trade {
    protected Underlying underlying2;
    protected Date expiryDate;
    protected Double strike;
    protected Double barrier;

    public BarrierOption() {
        super();
    }

    public BarrierOption(String book,
                         Double quantity,
                         Underlying underlying1,
                         Underlying underlying2,
                         Date expiryDate,
                         Double strike,
                         Double barrier) {
        super(TradeKind.Any, TradeType.BarrierOption, book, quantity, underlying1);
        this.underlying2 = underlying2;
        this.expiryDate = expiryDate;
        this.strike = strike;
        this.barrier = barrier;
    }

    public BarrierOption(BarrierOption barrierOption) {
        super(barrierOption);
        this.expiryDate = barrierOption.expiryDate;
        this.strike = barrierOption.strike;
        this.barrier = barrierOption.barrier;
    }

    @Override
    public BarrierOption createNewVersion() {
        return new BarrierOption(this);
    }

    public Underlying getUnderlying2() {
        return underlying2;
    }

    public Double getUnderlying2Amount() {
        return this.getUnderlying1Amount() * this.strike * -1;
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


}
