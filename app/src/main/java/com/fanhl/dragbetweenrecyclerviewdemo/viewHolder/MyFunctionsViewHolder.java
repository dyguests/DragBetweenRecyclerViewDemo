package com.fanhl.dragbetweenrecyclerviewdemo.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.fanhl.dragbetweenrecyclerviewdemo.adapter.MyFunctionAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.common.ClickableAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.helper.SimpleItemTouchHelperCallback;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

import java.util.List;

/**
 * Created by fanhl on 2017/4/10.
 */

public class MyFunctionsViewHolder extends FunctionsViewHolder {
    private MyFunctionAdapter functionAdapter;

    public MyFunctionsViewHolder(@NonNull View view, Callback callback) {
        super(view, callback);
    }

    @Override
    protected void initData() {
        super.initData();
        functionAdapter = new MyFunctionAdapter();
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
        recyclerView.setAdapter(functionAdapter);

        new ItemTouchHelper(new SimpleItemTouchHelperCallback(functionAdapter))
                .attachToRecyclerView(recyclerView);
    }

    @Override
    public void bindData(@NonNull String title, @NonNull List<MainModel.FunctionItemWrap> functionItems) {
        super.bindData(title, functionItems);
        functionAdapter.replaceItems(functionItems);
    }

    @Override
    public void setEditMode(boolean editMode) {
        functionAdapter.setEditMode(editMode);
    }

    @Override
    public MainModel.FunctionItemWrap getFunctionBarItem(int position) {
        return functionAdapter.getList().get(position);
    }

    public void addFunctionItem(MainModel.FunctionItemWrap functionItemWrap) {
        functionAdapter.addItem(functionItemWrap);
    }

    public MainModel.FunctionItemWrap removeFunctionItem(int position) {
        return functionAdapter.removeItem(position);
    }
}
