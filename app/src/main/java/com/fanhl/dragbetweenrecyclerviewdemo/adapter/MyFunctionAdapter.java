package com.fanhl.dragbetweenrecyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanhl.dragbetweenrecyclerviewdemo.R;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

/**
 * Created by fanhl on 2017/4/10.
 */

public class MyFunctionAdapter extends FunctionAdapter<MyFunctionAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funtion, parent, false));
    }

    public MainModel.FunctionItemWrap removeItem(int position) {
        MainModel.FunctionItemWrap functionItemWrap = list.remove(position);
        notifyItemRemoved(position);
        return functionItemWrap;
    }

    public class ViewHolder extends FunctionAdapter.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(MainModel.FunctionItemWrap data) {
            super.bindData(data);
            if (editMode) {
                editHintImg.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
            }
        }
    }
}
