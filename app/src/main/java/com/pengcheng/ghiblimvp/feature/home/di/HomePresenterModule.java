package com.pengcheng.ghiblimvp.feature.home.di;


import com.pengcheng.ghiblimvp.feature.home.HomeContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ypc on 1/20/2018.
 */
@Module
public class HomePresenterModule {

    private HomeContract.View view;

    public HomePresenterModule(HomeContract.View view) {
        this.view = view;
    }

    @Provides
    HomeContract.View provideView() {
        return view;
    }
}
