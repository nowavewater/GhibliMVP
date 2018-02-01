package com.pengcheng.ghiblimvp.data.repository;

import com.pengcheng.ghiblimvp.data.http.datasource.ApiDataSource;
import com.pengcheng.ghiblimvp.data.http.datasource.ApiLocalDataSource;
import com.pengcheng.ghiblimvp.data.http.datasource.ApiRemoteDataSource;
import com.pengcheng.ghiblimvp.data.preference.datasource.PrefDataSource;
import com.pengcheng.ghiblimvp.data.preference.datasource.PreferenceDataSource;
import com.pengcheng.ghiblimvp.data.repository.scope.Local;
import com.pengcheng.ghiblimvp.data.repository.scope.Preference;
import com.pengcheng.ghiblimvp.data.repository.scope.Remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GhibliRepositoryModule {

    @Provides
    @Local
    @Singleton
    public ApiDataSource provideLocalDataSource(ApiLocalDataSource localDataSource) {
        return localDataSource;
    }

    @Provides
    @Remote
    @Singleton
    public ApiDataSource provideRemoteDataSource(ApiRemoteDataSource remoteDataSource) {
        return remoteDataSource;
    }

    @Provides
    @Preference
    @Singleton
    public PrefDataSource providePreferenceDataSource(PreferenceDataSource prefDataSource) {
        return prefDataSource;
    }

}
