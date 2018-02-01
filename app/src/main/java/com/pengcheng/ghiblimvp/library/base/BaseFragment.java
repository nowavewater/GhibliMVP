package com.pengcheng.ghiblimvp.library.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pengcheng.ghiblimvp.GhibliApp;
import com.pengcheng.ghiblimvp.data.repository.GhibliRepositoryComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {

    private int fragmentLayout;

    protected Unbinder unbinder;

    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleRegistry.markState(Lifecycle.State.CREATED);

        initializePresenter();

        initializeVariables();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
    }

    @NonNull
    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }


    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(fragmentLayout, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupWidgets();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null){
            unbinder.unbind();
        }

    }

    protected void setFragmentLayout(int layout){
        fragmentLayout = layout;
    }

    protected abstract void initializePresenter();

    protected abstract void initializeVariables();

    protected abstract void setupWidgets();


    protected GhibliRepositoryComponent getGhibliComponent() {
        return ((GhibliApp) getActivity().getApplication()).getGhibliRepositoryComponent();
    }
}
