package com.pengcheng.ghiblimvp.data.http.service;

import com.pengcheng.ghiblimvp.data.http.entity.Film;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ypc on 2/1/2018.
 */

public interface ApiService {

    @GET("films")
    Flowable<List<Film>> getFilms();

}
