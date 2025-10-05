package com.aleynatombas.favorialtinnapp;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private static final String PREF_NAME = "favorites";
    private SharedPreferences sharedPreferences;

    public Prefs(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context null olamaz!");
        }
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveFavorite(int id) {
        if (sharedPreferences != null)
            sharedPreferences.edit().putBoolean(String.valueOf(id), true).apply();
    }

    public void removeFavorite(int id) {
        if (sharedPreferences != null)
            sharedPreferences.edit().remove(String.valueOf(id)).apply();
    }

    public boolean isFavorite(int id) {
        return sharedPreferences != null && sharedPreferences.getBoolean(String.valueOf(id), false);
    }

    public void clearAllFavorites() {
        if (sharedPreferences != null)
            sharedPreferences.edit().clear().apply();
    }
}
