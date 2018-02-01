package com.pengcheng.ghiblimvp;

import android.app.Application;

import com.pengcheng.ghiblimvp.data.http.ApiServiceModule;
import com.pengcheng.ghiblimvp.data.preference.PreferenceModule;
import com.pengcheng.ghiblimvp.data.repository.AppModule;
import com.pengcheng.ghiblimvp.data.repository.DaggerGhibliRepositoryComponent;
import com.pengcheng.ghiblimvp.data.repository.GhibliRepositoryComponent;
import com.pengcheng.ghiblimvp.data.repository.GhibliRepositoryModule;

/**
 * Created by ypc on 2/1/2018.
 */

public class GhibliApp extends Application {

    private GhibliRepositoryComponent ghibliRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependencies();
    }

    private void initializeDependencies() {
        ghibliRepositoryComponent = DaggerGhibliRepositoryComponent.builder()
                .ghibliRepositoryModule(new GhibliRepositoryModule())
                .preferenceModule(new PreferenceModule())
                .appModule(new AppModule(this))
                .build();
    }

    public GhibliRepositoryComponent getGhibliRepositoryComponent() {
        return ghibliRepositoryComponent;
    }

}
