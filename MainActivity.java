package com.aleynatombas.favorialtinnapp;

import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<AltinItem> goldList;
    private RecyclerView recyclerView;
    private GoldAdapter adapter;
    private ProgressBar progressBar;
    private Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Prefs nesnesini oluştur
        prefs = new Prefs(this);

        goldList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new GoldAdapter(this, goldList, prefs);
        recyclerView.setAdapter(adapter);

        fetchAltinFiyatlari();
    }

    private void fetchAltinFiyatlari() {
        // Loading göster
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        AltinApi altinApi = RetrofitClient.getClient().create(AltinApi.class);
        Call<Map<String, AltinItem>> call = altinApi.getAltinFiyatlari();

        call.enqueue(new Callback<Map<String, AltinItem>>() {
            @Override
            public void onResponse(Call<Map<String, AltinItem>> call, Response<Map<String, AltinItem>> response) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                
                if (response.isSuccessful() && response.body() != null) {
                    Map<String, AltinItem> data = response.body();

                    // Update_Date ve diğer gereksiz alanları kaldır
                    data.remove("Update_Date");
                    data.remove("USD");
                    data.remove("EUR");
                    data.remove("GBP");

                    goldList.clear();

                    for (Map.Entry<String, AltinItem> entry : data.entrySet()) {
                        String key = entry.getKey();
                        AltinItem fiyat = entry.getValue();

                        // Sadece altın ile ilgili verileri al
                        if (key.contains("Altın") || key.contains("Gram") || key.contains("Çeyrek") || 
                            key.contains("Yarım") || key.contains("Tam")) {
                            fiyat.setTur(key);
                            goldList.add(fiyat);
                        }
                    }

                    if (goldList.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Altın verisi bulunamadı", Toast.LENGTH_SHORT).show();
                    }

                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Veri alınamadı! Response code: " + response.code());
                    Toast.makeText(MainActivity.this, "Veri alınamadı: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Map<String, AltinItem>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                
                Log.e("MainActivity", "İstek başarısız: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Bağlantı hatası: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
