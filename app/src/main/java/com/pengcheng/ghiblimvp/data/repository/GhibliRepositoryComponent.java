package com.pengcheng.ghiblimvp.data.repository;

import com.pengcheng.ghiblimvp.data.http.ApiServiceModule;
import com.pengcheng.ghiblimvp.data.preference.PreferenceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { GhibliRepositoryModule.class, AppModule.class, ApiServiceModule.class, PreferenceModule.class})
public interface GhibliRepositoryComponent {
    GhibliRepository provideGhibliRepository();
}
