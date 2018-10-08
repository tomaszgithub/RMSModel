package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.CalculationContextId;
import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.id.TradePopulationId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Random;

public class Delta extends Risk {
    protected final String nameValue = "value";
    protected final String nameUnderlying = "underlying";

    public Delta() {
        super();
        this.riskType = RiskType.DELTA;
    }

    public Delta(Risk r) {
        super(r);
    }

    public Delta(CalculationContextId calculationId, MarketEnvId marketEnvId, TradePopulationId tradePopulationId, RiskRunId riskRunId, String bookName, Tcn tcn, Underlying underlying) {
        super(calculationId, marketEnvId, tradePopulationId, riskRunId, bookName, tcn);
        this.riskType = RiskType.DELTA;
        this.kvp.put(this.nameValue,(new Random()).nextDouble());
        this.kvp.put(this.nameUnderlying, underlying);
    }

    public Double getValue() {
        return (Double)this.kvp.get(this.nameValue);
    }

    public Underlying getUnderlying() {
        return (Underlying)this.kvp.get(this.nameUnderlying);
    }
}
