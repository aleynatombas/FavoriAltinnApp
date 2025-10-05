package com.aleynatombas.favorialtinnapp;

public class Summary {
    private int totalCount;
    private double averageBuyPrice;
    private double averageSellPrice;
    private String lastUpdate;
    private PriceRanges priceRanges;

    public int getTotalCount() { return totalCount; }
    public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

    public double getAverageBuyPrice() { return averageBuyPrice; }
    public void setAverageBuyPrice(double averageBuyPrice) { this.averageBuyPrice = averageBuyPrice; }

    public double getAverageSellPrice() { return averageSellPrice; }
    public void setAverageSellPrice(double averageSellPrice) { this.averageSellPrice = averageSellPrice; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    public PriceRanges getPriceRanges() { return priceRanges; }
    public void setPriceRanges(PriceRanges priceRanges) { this.priceRanges = priceRanges; }
}

class PriceRanges {
    private double minBuyPrice;
    private double maxBuyPrice;
    private double minSellPrice;
    private double maxSellPrice;

    public double getMinBuyPrice() { return minBuyPrice; }
    public void setMinBuyPrice(double minBuyPrice) { this.minBuyPrice = minBuyPrice; }

    public double getMaxBuyPrice() { return maxBuyPrice; }
    public void setMaxBuyPrice(double maxBuyPrice) { this.maxBuyPrice = maxBuyPrice; }

    public double getMinSellPrice() { return minSellPrice; }
    public void setMinSellPrice(double minSellPrice) { this.minSellPrice = minSellPrice; }

    public double getMaxSellPrice() { return maxSellPrice; }
    public void setMaxSellPrice(double maxSellPrice) { this.maxSellPrice = maxSellPrice; }
}
