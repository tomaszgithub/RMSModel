package com.reporting.mocks.model.trade;

import com.reporting.mocks.model.underlying.Underlying;

public abstract class Trade {
    protected TradeKind kind;
    protected Tcn tcn;
    protected String book;
    protected TradeType tradeType;
    protected Double quantity;
    protected BuySell buySell;

    protected Trade(TradeKind kind,
                    TradeType tradeType,
                    Tcn tcn,
                    String book,
                    Double quantity,
                    BuySell buySell) {
        this.kind = kind;
        this.tradeType = tradeType;
        this.tcn = tcn;
        this.book = book;
        this.quantity = quantity;
        this.buySell = buySell;
    }

    public Trade(TradeKind kind, TradeType tradeType, String book) {
        this(kind, tradeType, new Tcn(), book, 0.0, BuySell.Sell);
    }

    public Trade(Trade trade) {
        this(trade.getKind(), trade.getTradeType(), trade.getTcn().createNewVersion(), trade.getBook(), trade.quantity, trade.buySell);
    }

    public abstract Underlying getUnderlying();

    public TradeKind getKind() {
        return kind;
    }

    public Tcn getTcn() {
        return tcn;
    }

    public int getVersion() {
        return this.tcn.version;
    }

    public String getBook() {
        return book;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setBuySell(BuySell buySell) {
        this.buySell = buySell;
    }

    public BuySell getBuySell() {
        return buySell;
    }

    public abstract Trade createNewVersion();

    @Override
    public String toString() {
        return "{Type: " + tradeType + ", Book: " + book + ", TCN: " + tcn + "}";
    }
}
