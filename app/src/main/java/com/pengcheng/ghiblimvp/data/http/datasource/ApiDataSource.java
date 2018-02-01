package com.pengcheng.ghiblimvp.data.http.datasource;

import com.pengcheng.ghiblimvp.data.http.entity.Film;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by ypc on 2/1/2018.
 */

public interface ApiDataSource {

    Flowable<List<Film>> getFilms();

}
