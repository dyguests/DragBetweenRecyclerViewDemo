package com.fanhl.dragbetweenrecyclerviewdemo.adapter;

/**
 * Created by fanhl on 2017/4/10.
 */

public class OtherFunctionAdapter extends FunctionAdapter {
    public void setFunctionItemStatusAdded(int position) {
        list.get(position).setAdded(true);
        notifyItemChanged(position);
    }
}
