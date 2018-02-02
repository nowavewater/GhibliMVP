package com.pengcheng.ghiblimvp.feature.home;


import com.pengcheng.ghiblimvp.data.http.entity.Film;
import com.pengcheng.ghiblimvp.library.base.BasePresenter;

import java.util.List;

public interface HomeContract {

    interface View {

        void showFilmList(List<Film> filmList);

    }

    interface Presenter extends BasePresenter<View> {

    }
}
