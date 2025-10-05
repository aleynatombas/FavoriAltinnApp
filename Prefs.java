package com.aleynatombas.favorialtinnapp;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences sharedPreferences;

    public Prefs(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context null olamaz!");
        }
        sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE);
    }


    public void saveFavorite(int id) {
        sharedPreferences.edit().putBoolean(String.valueOf(id), true).apply();
    }

    public void removeFavorite(int id) {
        sharedPreferences.edit().remove(String.valueOf(id)).apply();
    }

    public boolean isFavorite(int id) {
        return sharedPreferences.getBoolean(String.valueOf(id), false);
    }
}
