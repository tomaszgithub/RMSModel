package com.reporting.mocks.model.underlying;

public abstract class Underlying {

    public abstract Currency getUnderlyingCurrency();

    public abstract int getComponenetCount();

    public abstract String getComponentName(int componentIndex);

}
