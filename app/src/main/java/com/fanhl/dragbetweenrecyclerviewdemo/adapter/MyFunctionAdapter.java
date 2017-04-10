package com.fanhl.dragbetweenrecyclerviewdemo.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanhl.dragbetweenrecyclerviewdemo.R;
import com.fanhl.dragbetweenrecyclerviewdemo.helper.ItemTouchHelperAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.helper.ItemTouchHelperViewHolder;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

import java.util.Collections;

/**
 * Created by fanhl on 2017/4/10.
 */

public class MyFunctionAdapter extends FunctionAdapter<MyFunctionAdapter.ViewHolder> implements ItemTouchHelperAdapter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funtion, parent, false));
    }

    public MainModel.FunctionItemWrap removeItem(int position) {
        MainModel.FunctionItemWrap functionItemWrap = list.remove(position);
        notifyItemRemoved(position);
        return functionItemWrap;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(list, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(list, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends FunctionAdapter.ViewHolder implements
            ItemTouchHelperViewHolder {

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

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}
