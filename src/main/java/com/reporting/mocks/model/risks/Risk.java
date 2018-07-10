package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.CalculationContextId;
import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.id.TradePopulationId;
import com.reporting.mocks.model.trade.Tcn;

import java.util.HashMap;
import java.util.Map;

public class Risk {
    protected CalculationContextId calculationContextId;
    protected MarketEnvId marketEnvId;
    protected TradePopulationId tradePopulationId;
    protected RiskRunId riskRunId;
    protected String bookName;
    protected Tcn tcn;
    protected RiskType riskType;

    protected Map<String, Object> kvp;  // set of key-value pairs representing the risk

    public Risk() {

    }

    protected Risk(Risk r) {
        this.kvp = new HashMap<>();
        this.calculationContextId = r.calculationContextId;
        this.marketEnvId = r.marketEnvId;
        this.tradePopulationId = r.tradePopulationId;
        this.riskRunId = r.riskRunId;
        this.bookName = r.bookName;
        this.tcn = r.tcn;
        this.riskType = r.riskType;
        this.kvp = r.kvp;
    }

    public Risk(CalculationContextId calculationId, MarketEnvId marketEnvId, TradePopulationId tradePopulationId, RiskRunId riskRunId, String bookName, Tcn tcn) {
        this.kvp = new HashMap<>();
        this.calculationContextId = calculationId;
        this.marketEnvId = marketEnvId;
        this.tradePopulationId = tradePopulationId;
        this.riskRunId = riskRunId;
        this.bookName = bookName;
        this.tcn = tcn;
    }

    public CalculationContextId getCalculationContextId() {
        return calculationContextId;
    }

    public MarketEnvId getMarketEnvId() {
        return marketEnvId;
    }

    public TradePopulationId getTradePopulationId() {
        return tradePopulationId;
    }

    public RiskRunId getRiskRunId() {
        return riskRunId;
    }

    public String getBookName() {
        return bookName;
    }

    public Tcn getTcn() {
        return tcn;
    }

    public RiskType getRiskType() {
        return riskType;
    }
}
