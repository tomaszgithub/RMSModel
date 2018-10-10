package com.reporting.mocks.model.trade.OtcTradeTypes;

import com.reporting.mocks.model.trade.OtcTrade;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.OtcUnderlying;

import java.util.Date;

public class VanillaOption extends OtcTrade {
    protected Date expiryDate;
    protected Double strike;
    protected Double amountCcy1;
    protected Double amountCcy2;

    public VanillaOption(OtcUnderlying underlying,
                Date expiryDate,
                Double strike,
                Double amountCcy1,
                Double amountCcy2,
                String book) {
        super(TradeType.VanillaOption, underlying, book);
        this.expiryDate = expiryDate;
        this.strike = strike;
        this.amountCcy1 = amountCcy1;
        this.amountCcy2 = amountCcy2;
    }

    public VanillaOption(VanillaOption vanillaOption) {
        super(vanillaOption);
        this.expiryDate = vanillaOption.expiryDate;
        this.strike = vanillaOption.strike;
        this.amountCcy1 = vanillaOption.amountCcy1;
        this.amountCcy2 = vanillaOption.amountCcy2;
    }


    @Override
    public OtcTrade createNewVersion() {
        return new VanillaOption(this);
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Double getStrike() {
        return strike;
    }

    public Double getAmountCcy1() {
        return amountCcy1;
    }

    public Double getAmountCcy2() {
        return amountCcy2;
    }
}
