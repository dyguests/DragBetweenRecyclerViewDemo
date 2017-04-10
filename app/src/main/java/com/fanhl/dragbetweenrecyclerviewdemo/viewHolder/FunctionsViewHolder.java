package com.fanhl.dragbetweenrecyclerviewdemo.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fanhl.dragbetweenrecyclerviewdemo.R;
import com.fanhl.dragbetweenrecyclerviewdemo.common.ClickableAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

import java.util.List;

/**
 * Created by fanhl on 2017/4/7.
 */
public abstract class FunctionsViewHolder {

    private final View view;
    private final TextView titleTv;
    protected final RecyclerView recyclerView;

    protected final Callback callback;

    public FunctionsViewHolder(@NonNull View view, Callback callback) {
        this.view = view;
        this.callback = callback;

        titleTv = ((TextView) view.findViewById(R.id.titleTv));
        recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerView));

        initData();
    }

    protected void initData() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void bindData(@NonNull String title, @NonNull List<MainModel.FunctionBarData.FunctionItemWrap> functionItems) {
        titleTv.setText(title);
        //functionAdapter.replaceItems(functionItems);
    }

    public abstract void setEditMode(boolean editMode);

    public interface Callback {
        void onItemClick(int position, ClickableAdapter.ViewHolder holder);

        void onItemLongClick(int position, ClickableAdapter.ViewHolder holder);
    }
}
