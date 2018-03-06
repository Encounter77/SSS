package com.ex.pojo;

public class Product extends Content {
    private boolean isBuy;
    private boolean isSell;
    private Double buyPrice;
    private long time;


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(boolean isBuy) {
        this.isBuy = isBuy;
    }

    public boolean getIsSell() {
        return isSell;
    }

    public void setIsSell(boolean isSell) {
        this.isSell = isSell;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "isBuy=" + isBuy +
                ", isSell=" + isSell +
                ", buyPrice=" + buyPrice +
                ", time=" + time +
                '}';
    }
}
