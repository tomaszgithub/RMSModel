package com.reporting.mocks.model.id;

import java.util.UUID;

public class TradePopulationId extends Id {
    public TradePopulationId() {
        super();
    }

    public TradePopulationId(String pricingGroupName, UUID id) {
        super("/tradepopulation/" + pricingGroupName, id);
    }

    public TradePopulationId(String pricingGroupName) {
        this(pricingGroupName, null);
    }
}
