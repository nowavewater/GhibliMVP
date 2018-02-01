package com.pengcheng.ghiblimvp.library.base;

import android.arch.lifecycle.LifecycleRegistry;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.pengcheng.ghiblimvp.GhibliApp;
import com.pengcheng.ghiblimvp.data.repository.GhibliRepositoryComponent;


public abstract class BaseActivity extends AppCompatActivity {

    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @NonNull
    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    protected GhibliRepositoryComponent getChaoBiComponent() {
        return ((GhibliApp) getApplication()).getGhibliRepositoryComponent();
    }

}
