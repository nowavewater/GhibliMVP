package com.pengcheng.ghiblimvp.data.http.datasource;

import com.pengcheng.ghiblimvp.data.http.entity.Film;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by ypc on 2/1/2018.
 */

public class ApiLocalDataSource implements ApiDataSource{

    @Inject
    public ApiLocalDataSource() {}

    @Override
    public Flowable<List<Film>> getFilms() {
        return null;
    }
}
