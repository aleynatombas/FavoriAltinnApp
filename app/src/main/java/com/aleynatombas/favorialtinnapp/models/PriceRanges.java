package com.aleynatombas.favorialtinnapp.models;

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
