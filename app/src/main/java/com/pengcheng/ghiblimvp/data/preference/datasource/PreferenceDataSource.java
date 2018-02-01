package com.pengcheng.ghiblimvp.data.preference.datasource;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by ypc on 2/1/2018.
 */

public class PreferenceDataSource implements PrefDataSource {

    private SharedPreferences sharedPreferences;

    @Inject
    public PreferenceDataSource(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void putString(String key, String value) {

    }

    @Override
    public String getString(String key, String defaultValue) {
        return null;
    }
}
