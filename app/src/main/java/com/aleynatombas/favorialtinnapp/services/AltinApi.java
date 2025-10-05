package com.aleynatombas.favorialtinnapp.services;

import java.util.List;

import com.aleynatombas.favorialtinnapp.models.GoldPrice;
import com.aleynatombas.favorialtinnapp.models.Summary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AltinApi {

    // 1. Tüm Altın Fiyatlarını Getir
    @GET("/api/goldprice")
    Call<List<GoldPrice>> getAllGoldPrices();

    // 2. ID'ye Göre Altın Fiyatı
    @GET("/api/goldprice/{id}")
    Call<GoldPrice> getGoldPriceById(@Path("id") int id);

    // 3. İsme Göre Altın Fiyatı Ara
    @GET("/api/goldprice/search")
    Call<List<GoldPrice>> searchGoldPrice(@Query("name") String name);

    // 4. Özet Bilgileri Getir
    @GET("/api/goldprice/summary")
    Call<Summary> getSummary();
}