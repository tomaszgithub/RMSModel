package com.reporting.mocks.model.risks;

public class Gamma extends Risk {
    public Gamma() {
        super();
        this.riskType = RiskType.GAMMA;
    }

    public Gamma(Risk r) {
        super(r);
    }
}
