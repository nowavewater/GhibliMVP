package com.pengcheng.ghiblimvp.feature.home;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.pengcheng.ghiblimvp.data.http.entity.Film;
import com.pengcheng.ghiblimvp.data.repository.GhibliRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class HomePresenter  implements HomeContract.Presenter, LifecycleObserver {

    private static final String TAG = HomePresenter.class.getSimpleName();

    private HomeContract.View view;

    private GhibliRepository repository;

    @Inject
    HomePresenter(HomeContract.View view, GhibliRepository repository) {
        this.view = view;
        this.repository = repository;


        // Initialize this presenter as a lifecycle-aware when a view is a lifecycle owner.
        if (view instanceof LifecycleOwner) {

            ((LifecycleOwner) view).getLifecycle().addObserver(this);
        }
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onAttach() {
        repository.getFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onDataReceived, this::handleError);

    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onDetach() {

    }

    private void onDataReceived(List<Film> filmList){
    }

    private void handleError(Throwable error) {

        error.printStackTrace();

    }

}
