package com.aleynatombas.favorialtinnapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<GoldPrice> goldList;
    private RecyclerView recyclerView;
    private GoldAdapter adapter;
    private ProgressBar progressBar;
    private Prefs prefs;
    private Call<List<GoldPrice>> call; // Activity destroy edildiğinde iptal edebilmek için

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = new Prefs(this);
        goldList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new GoldAdapter(this, goldList, prefs);
        recyclerView.setAdapter(adapter);

        fetchGoldPrices();
    }

    private void fetchGoldPrices() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        AltinApi altinApi = RetrofitClient.getClient().create(AltinApi.class);

        // Direkt List<GoldPrice> çağırıyoruz
        call = altinApi.getAllGoldPrices();

        call.enqueue(new Callback<List<GoldPrice>>() {
            @Override
            public void onResponse(Call<List<GoldPrice>> call, Response<List<GoldPrice>> response) {
                // UI thread üzerinden güvenli şekilde güncelle
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                    if (response.isSuccessful() && response.body() != null) {
                        goldList.clear();
                        goldList.addAll(response.body());
                        adapter.notifyDataSetChanged();
                        Log.d("MainActivity", "Altın verileri alındı: " + goldList.size());
                    } else {
                        Toast.makeText(MainActivity.this, "Veri yok veya hata oluştu", Toast.LENGTH_SHORT).show();
                        showSampleData();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<GoldPrice>> call, Throwable t) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Bağlantı hatası: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    showSampleData();
                });
            }
        });
    }

    private void showSampleData() {
        goldList.clear();

        GoldPrice sample1 = new GoldPrice();
        sample1.setName("Gram Altın");
        sample1.setBuyPrice(2150.00);
        sample1.setSellPrice(2155.00);
        sample1.setChange(0.5);
        sample1.setCurrency("TRY");
        goldList.add(sample1);

        GoldPrice sample2 = new GoldPrice();
        sample2.setName("Çeyrek Altın");
        sample2.setBuyPrice(8600.00);
        sample2.setSellPrice(8620.00);
        sample2.setChange(0.3);
        sample2.setCurrency("TRY");
        goldList.add(sample2);

        GoldPrice sample3 = new GoldPrice();
        sample3.setName("Yarım Altın");
        sample3.setBuyPrice(17200.00);
        sample3.setSellPrice(17240.00);
        sample3.setChange(0.4);
        sample3.setCurrency("TRY");
        goldList.add(sample3);

        GoldPrice sample4 = new GoldPrice();
        sample4.setName("Tam Altın");
        sample4.setBuyPrice(34400.00);
        sample4.setSellPrice(34480.00);
        sample4.setChange(0.4);
        sample4.setCurrency("TRY");
        goldList.add(sample4);

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Activity kapanırken çağrıyı iptal et
        if (call != null) {
            call.cancel();
        }
    }
}
