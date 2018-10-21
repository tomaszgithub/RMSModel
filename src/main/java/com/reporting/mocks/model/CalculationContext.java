package com.reporting.mocks.model;

import com.reporting.mocks.model.id.CalculationContextId;
import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.risks.RiskType;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    A CalculationContext represents a set of associations between a risk type and a market environment.
    The association is used to determine which market environment should be used to calculate the specific
    risk.
 */
public class CalculationContext {

    protected PricingGroup pricingGroup;
    protected CalculationContextId calculationContextId;
    protected Date timeStamp;
    protected Map<RiskType, MarketEnvId> markets;
    private long timeStampGen = System.currentTimeMillis();


    public CalculationContext() {
    }

    public CalculationContext(PricingGroup pricingGroup) {
        this.pricingGroup = pricingGroup;
        this.calculationContextId = new CalculationContextId(pricingGroup.getName());
        this.timeStamp = new Date();
        this.markets = new HashMap<>();
    }

    public CalculationContext(CalculationContext calcContext) {
        this(calcContext.getPricingGroup());
        this.markets = new HashMap<>(calcContext.markets);
    }

    public void update(List<RiskType> riskTypes, MarketEnv marketEnv) {
        for(RiskType riskType : riskTypes) {
            markets.put(riskType, marketEnv.getId());
        }
    }

    public void add(RiskType riskType, MarketEnv marketEnv) {
        this.markets.put(riskType, marketEnv.getId());
    }

    public MarketEnvId get(RiskType riskType) {
        return markets.get(riskType);

    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public Map<RiskType, MarketEnvId> getMarkets() {
        return markets;
    }

    public PricingGroup getPricingGroup() {
        return this.pricingGroup;
    }

    public CalculationContextId getCalculationContextId() {
        return this.calculationContextId;
    }

    public long getTimeStampGen() {
        return timeStampGen;
    }
}
