package com.pengcheng.ghiblimvp.feature.home;

import android.os.Bundle;

import com.pengcheng.ghiblimvp.R;
import com.pengcheng.ghiblimvp.feature.home.di.DaggerHomeComponent;
import com.pengcheng.ghiblimvp.feature.home.di.HomePresenterModule;
import com.pengcheng.ghiblimvp.library.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements HomeContract.View {

    @Inject
    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initializePresenter();

    }

    protected void initializePresenter(){
        DaggerHomeComponent.builder()
                .ghibliRepositoryComponent(getChaoBiComponent())
                .homePresenterModule(new HomePresenterModule(this))
                .build()
                .inject(this);
    }
}
