package com.aleynatombas.favorialtinnapp;

import com.google.gson.annotations.SerializedName;

public class AltinResponse {

    @SerializedName("Update_Date")
    private String updateDate;

    @SerializedName("USD")
    private AltinModel USD;

    @SerializedName("EUR")
    private AltinModel EUR;

    @SerializedName("GAU")
    private AltinModel GAU;

    @SerializedName("GBP")
    private AltinModel GBP;

    @SerializedName("CHF")
    private AltinModel CHF;

    // Getter ve Setter'lar

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public AltinModel getUSD() {
        return USD;
    }

    public void setUSD(AltinModel USD) {
        this.USD = USD;
    }

    public AltinModel getEUR() {
        return EUR;
    }

    public void setEUR(AltinModel EUR) {
        this.EUR = EUR;
    }

    public AltinModel getGAU() {
        return GAU;
    }

    public void setGAU(AltinModel GAU) {
        this.GAU = GAU;
    }

    public AltinModel getGBP() {
        return GBP;
    }

    public void setGBP(AltinModel GBP) {
        this.GBP = GBP;
    }

    public AltinModel getCHF() {
        return CHF;
    }

    public void setCHF(AltinModel CHF) {
        this.CHF = CHF;
    }
}
