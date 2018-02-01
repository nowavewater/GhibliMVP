package com.pengcheng.ghiblimvp.library.base;

/**
 * Created by ypc on 12/1/2017.
 */

public interface BasePresenter<V> {
    void onAttach();
    void onDetach();
}
