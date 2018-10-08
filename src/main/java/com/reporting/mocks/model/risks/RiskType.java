package com.reporting.mocks.model.risks;

public enum RiskType {
    PV("PV"),
    DELTA("Delta"),
    GAMMA("Gamma"),
    VEGA("Vega");

    protected String name;

    RiskType(String name) {
        this.name = name;
    }
}
