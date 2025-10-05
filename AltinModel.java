package com.aleynatombas.favorialtinnapp;

import com.google.gson.annotations.SerializedName;

public class AltinModel {

    @SerializedName("Update_Date")
    private String updateDate;

    @SerializedName("gram-altin")
    private AltinItem gramAltin;

    @SerializedName("ceyrek-altin")
    private AltinItem ceyrekAltin;

    @SerializedName("yarim-altin")
    private AltinItem yarimAltin;

    @SerializedName("tam-altin")
    private AltinItem tamAltin;

    @SerializedName("cumhuriyet-altini")
    private AltinItem cumhuriyetAltini;

    // Diğer altın türleri eklenebilir...

    public String getUpdateDate() {
        return updateDate;
    }

    public AltinItem getGramAltin() {
        return gramAltin;
    }

    public AltinItem getCeyrekAltin() {
        return ceyrekAltin;
    }

    public AltinItem getYarimAltin() {
        return yarimAltin;
    }

    public AltinItem getTamAltin() {
        return tamAltin;
    }

    public AltinItem getCumhuriyetAltini() {
        return cumhuriyetAltini;
    }
}
