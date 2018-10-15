package com.reporting.mocks.model.id;

import java.util.UUID;

public class MarketEnvId extends Id {

    public MarketEnvId() {
        super();
    }

    public MarketEnvId(String pricingGroupName, UUID id) {
        super("/calculationcontext/market/" + pricingGroupName, id);
    }
    public MarketEnvId(String pricingGroupName) {
        this(pricingGroupName, null);
    }
}
