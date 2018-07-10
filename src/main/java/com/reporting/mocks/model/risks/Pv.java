package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.CalculationContextId;
import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.id.TradePopulationId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Currency;

import java.util.Random;

public class Pv extends Risk {
    private final String nameValue = "value";
    private final String nameCurrency = "currency";

    public Pv() {
        super();
        this.riskType = RiskType.PV;
    }

    public Pv(CalculationContextId calculationId, MarketEnvId marketEnvId, TradePopulationId tradePopulationId, RiskRunId riskRunId, String bookName, Tcn tcn, Currency currency) {
        super(calculationId, marketEnvId, tradePopulationId, riskRunId, bookName, tcn);
        Random rand = new Random();
        this.riskType = RiskType.PV;

        this.kvp.put(this.nameValue, rand.nextDouble());
        this.kvp.put(this.nameCurrency, currency);
    }

    public Pv(Risk r) {
        super(r);
    }

    public Double getValue() {
        return (Double)this.kvp.get(this.nameValue);
    }

    public Currency getCurrency() {
        return (Currency)this.kvp.get(this.nameCurrency);
    }

    @Override
    public RiskType getRiskType() {
        return RiskType.PV;
    }
}
