package com.aleynatombas.favorialtinnapp;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AltinApi {
    @GET("today.json") // Doğru endpoint
    Call<Map<String, AltinItem>> getAltinFiyatlari();
}
