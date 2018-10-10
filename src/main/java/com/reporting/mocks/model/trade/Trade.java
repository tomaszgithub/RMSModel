package com.reporting.mocks.model.trade;


import com.reporting.mocks.model.underlying.Underlying;

public abstract class Trade {
    protected TradeKind kind;
    protected Tcn tcn;
    protected String book;
    protected TradeType tradeType;
    protected Double quantity;
    protected Underlying underlying1;

    protected Trade(TradeKind kind,
                    TradeType tradeType,
                    Tcn tcn,
                    String book,
                    Double quantity,
                    Underlying underlying1) {
        this.kind = kind;
        this.tradeType = tradeType;
        this.tcn = tcn;
        this.book = book;
        this.quantity = quantity;
        this.underlying1 = underlying1;
    }

    protected Trade(TradeKind kind,
                    TradeType tradeType,
                    String book,
                    Double quantity,
                    Underlying underlying1) {
        this(kind, tradeType, new Tcn(), book, quantity, underlying1);
    }

//    public Trade(TradeKind kind, TradeType tradeType, String book) {
//        this(kind, tradeType, new Tcn(), book, 0.0);
//    }

    public Trade(Trade trade) {
        this(trade.getKind(), trade.getTradeType(), trade.getTcn().createNewVersion(), trade.getBook(), trade.quantity, trade.underlying1);
    }

    public abstract Trade createNewVersion();

    public TradeKind getKind() {
        return kind;
    }

    public Tcn getTcn() {
        return tcn;
    }

    public String getBook() {
        return book;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Underlying getUnderlying1() {
        return underlying1;
    }

    public int getVersion() { return this.tcn.getVersion(); }

    @Override
    public String toString() {
        return "{Type: " + tradeType + ", Book: " + book + ", TCN: " + tcn + "}";
    }
}
