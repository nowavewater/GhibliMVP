package com.pengcheng.ghiblimvp.feature.home.di;


import com.pengcheng.ghiblimvp.data.repository.GhibliRepositoryComponent;
import com.pengcheng.ghiblimvp.feature.home.MainActivity;
import com.pengcheng.ghiblimvp.library.base.ActivityScope;

import dagger.Component;

/**
 * Created by ypc on 1/20/2018.
 */
@ActivityScope
@Component(modules = { HomePresenterModule.class }, dependencies = { GhibliRepositoryComponent.class })
public interface HomeComponent {
    void inject(MainActivity activity);
}
