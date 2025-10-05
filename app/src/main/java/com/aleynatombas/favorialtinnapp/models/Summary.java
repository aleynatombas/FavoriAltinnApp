package com.aleynatombas.favorialtinnapp.models;

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

