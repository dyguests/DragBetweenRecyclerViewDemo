package com.fanhl.dragbetweenrecyclerviewdemo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanhl.dragbetweenrecyclerviewdemo.R;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

/**
 * Created by fanhl on 2017/4/10.
 */

public class OtherFunctionAdapter extends FunctionAdapter<OtherFunctionAdapter.ViewHolder> {
    public static final String TAG = OtherFunctionAdapter.class.getSimpleName();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funtion, parent, false));
    }

    public void setFunctionItemStatusAdded(int position, boolean added) {
        list.get(position).setAdded(added);
        notifyItemChanged(position);
    }

    public void setFunctionItemStatusAdded2(MainModel.FunctionItemWrap functionItemWrap, boolean added) {
        int position = list.indexOf(functionItemWrap);
        if (position >= 0) {
            list.get(position).setAdded(added);
            notifyItemChanged(position);
        } else {
            Log.e(TAG, "没找到functionItemWrap的position", new Exception());
        }
    }

    public class ViewHolder extends FunctionAdapter.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(MainModel.FunctionItemWrap data) {
            super.bindData(data);
            if (editMode) {
                if (data.isAdded()) {
                    editHintImg.setImageResource(android.R.drawable.star_big_off);
                } else {
                    editHintImg.setImageResource(android.R.drawable.ic_input_add);
                }
            }

        }
    }
}
