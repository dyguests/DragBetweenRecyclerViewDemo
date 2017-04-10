package com.fanhl.dragbetweenrecyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fanhl.dragbetweenrecyclerviewdemo.data.FunctionItem;

import java.util.List;

/**
 * Created by fanhl on 2017/4/7.
 */

class FunctionsViewHolder {

    private final View view;
    private final TextView titleTv;
    private final RecyclerView recyclerView;

    private FunctionAdapter functionAdapter;

    public FunctionsViewHolder(@NonNull View view) {
        this.view = view;
        titleTv = ((TextView) view.findViewById(R.id.titleTv));
        recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerView));

        initData();
    }

    private void initData() {
        functionAdapter = new FunctionAdapter();
        recyclerView.setAdapter(functionAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void bindData(@NonNull String title, @NonNull List<FunctionItem> functionItems) {
        titleTv.setText(title);
        functionAdapter.replaceItems(functionItems);
    }

    public void setEditMode(boolean editMode) {
        functionAdapter.setEditMode(editMode);
    }
}
