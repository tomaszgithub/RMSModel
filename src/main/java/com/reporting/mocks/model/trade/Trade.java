package com.reporting.mocks.model.trade;


import com.reporting.mocks.model.underlying.Underlying;

import java.util.HashMap;
import java.util.Map;

public class Trade {
    protected TradeKind kind;
    protected Tcn tcn;
    protected String book;
    protected TradeType tradeType;
    protected Double underlying1Amount;
    protected Underlying underlying1;

    protected Map<String, Object> kvp;

    public Trade() {
    }

    protected Trade(TradeKind kind,
                    TradeType tradeType,
                    Tcn tcn,
                    String book,
                    Double underlying1Amount,
                    Underlying underlying1) {
        this.kind = kind;
        this.tradeType = tradeType;
        this.tcn = tcn;
        this.book = book;
        this.underlying1Amount = underlying1Amount;
        this.underlying1 = underlying1;
        this.kvp = new HashMap<>();
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
        this(trade.getKind(), trade.getTradeType(), trade.getTcn().createNewVersion(), trade.getBook(), trade.underlying1Amount, trade.underlying1);
    }

    protected void assignAttribute(String key, Object value) {
        this.kvp.put(key, value);
    }

    protected Object retreiveAttribute(String key) {
        return this.kvp.get(key);
    }

    public Trade createNewVersion() {
        return new Trade(this.kind, this.tradeType, this.getTcn().createNewVersion(), this.book, this.underlying1Amount, this.underlying1);
    }

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

    public Double getUnderlying1Amount() {
        return underlying1Amount;
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
