package com.pengcheng.ghiblimvp.data.http.datasource;

import com.pengcheng.ghiblimvp.data.http.entity.Film;
import com.pengcheng.ghiblimvp.data.http.service.ApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by ypc on 2/1/2018.
 */

public class ApiRemoteDataSource implements ApiDataSource {

    private ApiService apiService;

    @Inject
    public ApiRemoteDataSource(ApiService  apiService) {
        this.apiService = apiService;
    }


    @Override
    public Flowable<List<Film>> getFilms() {
        return apiService.getFilms();
    }
}
