package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;

public class BarrierOption extends Trade {
    private final String underlying2 = "underlying2";
    private final String expiryDate = "expiryDate";
    private final String strike = "strike";
    private final String barrier = "barrier";

    public BarrierOption() {
        super();
    }

    protected BarrierOption(String book,
                            Tcn tcn,
                            Double quantity,
                            Underlying underlying1,
                            Underlying underlying2,
                            Date expiryDate,
                            Double strike,
                            Double barrier) {
        super(TradeKind.Any, TradeType.BarrierOption, tcn, book, quantity, underlying1);
        this.assignAttribute(this.underlying2, underlying2);
        this.assignAttribute(this.expiryDate, expiryDate);
        this.assignAttribute(this.strike, strike);
        this.assignAttribute(this.barrier, barrier);
    }

    public BarrierOption(String book,
                         Double quantity,
                         Underlying underlying1,
                         Underlying underlying2,
                         Date expiryDate,
                         Double strike,
                         Double barrier) {
        this(book, new Tcn(), quantity, underlying1, underlying2, expiryDate, strike, barrier);
    }

    public BarrierOption(BarrierOption barrierOption) {
        this(barrierOption.getBook(),
                barrierOption.getUnderlying1Amount(),
                barrierOption.getUnderlying1(),
                barrierOption.getUnderlying2(),
                barrierOption.getExpiryDate(),
                barrierOption.getStrike(),
                barrierOption.getBarrier());
    }

    @Override
    public BarrierOption createNewVersion() {
        return new BarrierOption(this.getBook(),
                this.getTcn().createNewVersion(),
                this.getUnderlying1Amount(),
                this.getUnderlying1(),
                this.getUnderlying2(),
                this.getExpiryDate(),
                this.getStrike(),
                this.getBarrier());
    }

    public Underlying getUnderlying2() {
        return (Underlying)this.retreiveAttribute(this.underlying2);
    }

    public Double getUnderlying2Amount() {
        return this.getUnderlying1Amount() * this.getStrike() * -1;
    }

    public Date getExpiryDate() {
        return (Date)this.retreiveAttribute(this.expiryDate);
    }

    public Double getStrike() {
        return (Double)this.retreiveAttribute(this.strike);
    }

    public Double getBarrier() {
        return (Double)this.retreiveAttribute(this.barrier);
    }


}
