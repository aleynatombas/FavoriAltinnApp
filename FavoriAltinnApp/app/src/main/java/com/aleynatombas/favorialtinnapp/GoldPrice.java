package com.aleynatombas.favorialtinnapp;

public class GoldPrice {
    private int id;
    private String name;
    private double buyPrice;
    private double sellPrice;
    private double change;
    private String changeType;
    private String lastUpdate;
    private String currency;

    // Getter ve Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBuyPrice() { return buyPrice; }
    public void setBuyPrice(double buyPrice) { this.buyPrice = buyPrice; }

    public double getSellPrice() { return sellPrice; }
    public void setSellPrice(double sellPrice) { this.sellPrice = sellPrice; }

    public double getChange() { return change; }
    public void setChange(double change) { this.change = change; }

    public String getChangeType() { return changeType; }
    public void setChangeType(String changeType) { this.changeType = changeType; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
