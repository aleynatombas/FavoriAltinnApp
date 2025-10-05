package com.aleynatombas.favorialtinnapp;

import com.google.gson.annotations.SerializedName;

public class AltinItem {
    @SerializedName("Alış")
    private String alis;

    @SerializedName("Satış")
    private String satis;

    @SerializedName("Değişim")
    private String degisim;

    @SerializedName("Tür")
    private String tur;

    // Boş constructor (Retrofit için önemli)
    public AltinItem() {}

    public String getAlis() {
        return alis;
    }

    public String getSatis() {
        return satis;
    }

    public String getDegisim() {
        return degisim;
    }

    public String getTur() {
        return tur;
    }

    // İşte burası eksik, eklemen gereken setter
    public void setTur(String tur) {
        this.tur = tur;
    }
}
