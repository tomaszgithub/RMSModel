package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;

public class VanillaOption extends Trade {
    protected Underlying underlying2;
    protected Date expiryDate;
    protected Double strike;

    public VanillaOption(
            String book,
            Double quantity,
            Underlying underlying1,
            Underlying underlying2,
            Date expiryDate,
            Double strike) {
        super(TradeKind.Any, TradeType.VanillaOption, book, quantity, underlying1);
        this.underlying2 = underlying2;
        this.expiryDate = expiryDate;
        this.strike = strike;
    }

    public VanillaOption(VanillaOption vanillaOption) {
        super(vanillaOption);
        this.underlying2 = vanillaOption.underlying2;
        this.expiryDate = vanillaOption.expiryDate;
        this.strike = vanillaOption.strike;
    }


    @Override
    public VanillaOption createNewVersion() {
        return new VanillaOption(this);
    }

    public Underlying getUnderlying2() {
        return underlying2;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Double getStrike() {
        return strike;
    }

    public Double getUnderlying2Amount() {
        return this.getUnderlying1Amount() * this.strike * -1;
    }
}
