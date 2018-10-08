package com.reporting.mocks.model.dataviews.book;

import com.reporting.mocks.model.risks.Risk;
import com.reporting.mocks.model.risks.RiskType;
import com.reporting.mocks.model.trade.Tcn;

import java.util.HashMap;
import java.util.UUID;

public class TcnRiskSet {
    Tcn tcn;
    HashMap<RiskType, Risk> risks;

    public TcnRiskSet() {
        this.risks = new HashMap<>();
    }

    public TcnRiskSet(Tcn tcn) {
        this();
        this.tcn = tcn;
    }

    public <T extends Risk> void setRisk(T r) {
        this.risks.put(r.getRiskType(), r);
    }

    public <T extends Risk> T getRisk(RiskType rt) {
        if (this.risks.containsKey(rt)) {
            return (T)this.risks.get(rt);
        }
        else {
            return null;
        }
    }

    public Tcn getTcn() {
        return tcn;
    }


}
