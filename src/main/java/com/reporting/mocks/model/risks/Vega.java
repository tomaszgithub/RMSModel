package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.CalculationContextId;
import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.id.TradePopulationId;
import com.reporting.mocks.model.trade.Tcn;

import java.lang.reflect.Array;
import java.util.List;

/*
    Vega is defined as an matrix of values each value is a time bucket by underlying, e.g.,

    +-----+----+----+----+----+----+
    +      OIS  1mth 6mth  1yr  2yr
    + EUR  0.1   0.2  0.3  0.4  0.2
    + USD  0.11  0.21 0.2  0.3  0.1
    +-----+----+----+---+----+----+
 */
public class Vega extends Risk {
    private final String nameTimeBuckets = "timeBuckets";
    private final String nameTimeBucketValues = "timeBucketValues";
    private final String nameCurrency = "underlying";


    public Vega() {
        super();
        this.riskType = RiskType.VEGA;
    }

    public Vega(Risk r) {
        super(r);
    }

    public Vega(CalculationContextId calculationId,
                MarketEnvId marketEnvId,
                TradePopulationId tradePopulationId,
                RiskRunId riskRunId,
                String bookName,
                Tcn tcn) {
        super(calculationId, marketEnvId, tradePopulationId, riskRunId, bookName, tcn);
        this.riskType = RiskType.VEGA;
    }

    public void addTimeBuckets(List<String> bucketNames) {
        this.kvp.put(this.nameTimeBuckets, bucketNames);
    }

    public void addTimeBuckValues(String underlying, List<Double> bucketValues) {
        this.kvp.put(underlying, bucketValues);
    }
}
