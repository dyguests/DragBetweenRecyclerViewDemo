package com.fanhl.dragbetweenrecyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fanhl.dragbetweenrecyclerviewdemo.common.ClickableAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.data.FunctionItem;

import java.util.List;

/**
 * Created by fanhl on 2017/4/7.
 */

class FunctionsViewHolder {

    private final View view;
    private final TextView titleTv;
    private final RecyclerView recyclerView;

    private final Callback callback;

    private FunctionAdapter functionAdapter;

    public FunctionsViewHolder(@NonNull View view, Callback callback) {
        this.view = view;
        this.callback = callback;

        titleTv = ((TextView) view.findViewById(R.id.titleTv));
        recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerView));

        initData();
    }

    private void initData() {
        functionAdapter = new FunctionAdapter();
        recyclerView.setAdapter(functionAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        functionAdapter.setOnItemClickListener(new ClickableAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {
                callback.onItemClick(position, holder);
            }
        });
        functionAdapter.setOnItemLongClickListener(new ClickableAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position, ClickableAdapter.ViewHolder holder) {
                callback.onItemLongClick(position, holder);
                return true;
            }
        });
    }

    public void bindData(@NonNull String title, @NonNull List<FunctionItem> functionItems) {
        titleTv.setText(title);
        functionAdapter.replaceItems(functionItems);
    }

    public void setEditMode(boolean editMode) {
        functionAdapter.setEditMode(editMode);
    }

    public interface Callback {
        void onItemClick(int position, ClickableAdapter.ViewHolder holder);

        void onItemLongClick(int position, ClickableAdapter.ViewHolder holder);
    }
}
