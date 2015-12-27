package com.akhil.youtubesample.preferences;


import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPreferences {

    private static final String SHARED_PREFERENCE_NAME = "AppSharedPreference";
    public static AppSharedPreferences sAppSharedPreferences;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private AppSharedPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static AppSharedPreferences getInstance(Context context) {
        if (sAppSharedPreferences == null) {
            sAppSharedPreferences = new AppSharedPreferences(context);
        }
        return sAppSharedPreferences;
    }

    public int getInteger(String key, int defaultVal) {
        return mSharedPreferences.getInt(key, defaultVal);
    }

    public void putInteger(String key, int defaultVal) {
        mEditor.putInt(key, defaultVal).apply();
    }

    public boolean getBoolean(String key, boolean defaultVal) {
        return mSharedPreferences.getBoolean(key, defaultVal);
    }

    public void putBoolean(String key, boolean defaultVal) {
        mEditor.putBoolean(key, defaultVal).apply();
    }

    public interface PreferenceKeys {
        String IS_LOGGED_IN = "is_logged_in";
    }
}
