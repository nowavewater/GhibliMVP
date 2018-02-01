package com.pengcheng.ghiblimvp.data.repository;

import com.pengcheng.ghiblimvp.data.http.datasource.ApiDataSource;
import com.pengcheng.ghiblimvp.data.http.entity.Film;
import com.pengcheng.ghiblimvp.data.preference.datasource.PrefDataSource;
import com.pengcheng.ghiblimvp.data.repository.scope.Local;
import com.pengcheng.ghiblimvp.data.repository.scope.Preference;
import com.pengcheng.ghiblimvp.data.repository.scope.Remote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by ypc on 2/1/2018.
 */

public class GhibliRepository implements ApiDataSource, PrefDataSource {

    private ApiDataSource remoteDataSource;
    private ApiDataSource localDataSource;
    private PrefDataSource preferenceDataSource;

    @Inject
    public GhibliRepository(
            @Local ApiDataSource localDataSource,
            @Remote ApiDataSource remoteDataSource,
            @Preference PrefDataSource preferenceDataSource
    ) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.preferenceDataSource = preferenceDataSource;

    }

    @Override
    public void putString(String key, String value) {

    }

    @Override
    public String getString(String key, String defaultValue) {
        return null;
    }

    @Override
    public Flowable<List<Film>> getFilms() {
        return remoteDataSource.getFilms();
    }
}
