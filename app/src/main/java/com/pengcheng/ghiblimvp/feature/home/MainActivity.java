package com.pengcheng.ghiblimvp.feature.home;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.pengcheng.ghiblimvp.R;
import com.pengcheng.ghiblimvp.data.http.entity.Film;
import com.pengcheng.ghiblimvp.feature.home.di.DaggerHomeComponent;
import com.pengcheng.ghiblimvp.feature.home.di.HomePresenterModule;
import com.pengcheng.ghiblimvp.library.base.BaseActivity;
import com.pengcheng.ghiblimvp.library.base.RecyclerViewListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements HomeContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.film_recycler_view)
    RecyclerView filmRecyclerView;

    @Inject
    HomePresenter presenter;

    private FilmAdapter filmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initializePresenter();

        setupWidgets();

    }

    protected void initializePresenter(){
        DaggerHomeComponent.builder()
                .ghibliRepositoryComponent(getChaoBiComponent())
                .homePresenterModule(new HomePresenterModule(this))
                .build()
                .inject(this);
    }

    private void setupWidgets() {
        filmAdapter = new FilmAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        filmRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(filmRecyclerView.getContext(), layoutManager.getOrientation());
        filmRecyclerView.addItemDecoration(mDividerItemDecoration);
        filmRecyclerView.setAdapter(filmAdapter);
        filmAdapter.setOnItemClickListener((view, position) -> {
            goToFilm(filmAdapter.getItem(position).getId());
        });
    }

    private void goToFilm(String id){



    }

    @Override
    public void showFilmList(List<Film> filmList) {
        filmAdapter.replaceData(filmList);
    }
}
