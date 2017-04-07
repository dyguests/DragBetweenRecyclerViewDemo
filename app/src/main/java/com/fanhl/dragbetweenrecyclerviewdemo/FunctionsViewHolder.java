package com.fanhl.dragbetweenrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by fanhl on 2017/4/7.
 */

class FunctionsViewHolder {

    private final View view;
    private final TextView titleTv;
    private final RecyclerView recyclerView;

    public FunctionsViewHolder(View view) {
        this.view = view;
        titleTv = ((TextView) view.findViewById(R.id.titleTv));
        recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerView));
    }
}
