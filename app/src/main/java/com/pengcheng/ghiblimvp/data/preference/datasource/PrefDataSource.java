package com.pengcheng.ghiblimvp.data.preference.datasource;


public interface PrefDataSource {

    void putString(String key, String value);

    String getString(String key, String defaultValue);

}
