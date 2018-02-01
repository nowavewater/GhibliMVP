package com.pengcheng.ghiblimvp.library.base;

import android.view.View;

/**
 * Created by ypc on 1/21/2018.
 */

public interface RecyclerViewListener {

    @FunctionalInterface
    interface OnItemClickListener {
        void OnItemClick(View view, int position);
    }

    @FunctionalInterface
    interface OnItemLongClickListener {
        void OnItemLongClick(View view, int position);
    }
}
