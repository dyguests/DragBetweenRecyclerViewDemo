package com.fanhl.dragbetweenrecyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanhl.dragbetweenrecyclerviewdemo.common.ClickableAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.common.Listable;
import com.fanhl.dragbetweenrecyclerviewdemo.data.FunctionItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhl on 2017/4/7.
 */

class FunctionAdapter extends ClickableAdapter<FunctionAdapter.ViewHolder> implements Listable<FunctionItem> {
    private final List<FunctionItem> list;
    /** 默认是非编辑模式 */
    private boolean editMode = false;

    public FunctionAdapter() {
        this.list = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funtion, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void addItem(FunctionItem item) {
        int position = list.size();
        list.add(item);
        notifyItemInserted(position);
    }

    @Override
    public void addItems(List<FunctionItem> items) {
        int positionStart = list.size();
        list.addAll(items);
        notifyItemRangeInserted(positionStart, items.size());
    }

    @Override
    public void clear() {
        int itemCount = list.size();
        list.clear();
        notifyItemRangeRemoved(0, itemCount);
    }

    @Override
    public void replaceItems(List<FunctionItem> items) {
        int oldSize = list.size();
        list.clear();
        list.addAll(items);
        int newSize = list.size();

        if (newSize == oldSize) {
            notifyItemRangeChanged(0, oldSize);
        } else if (newSize > oldSize) {
            notifyItemRangeChanged(0, oldSize);
            notifyItemRangeInserted(oldSize, newSize - oldSize);
        } else {
            notifyItemRangeChanged(0, newSize);
            notifyItemRangeRemoved(newSize, oldSize - newSize);
        }
    }

    @Override
    public void addFirstItem(FunctionItem item) {
        throw new RuntimeException("没空实现 先不写");
    }

    @Override
    public void addFirstItems(List<FunctionItem> items) {
        throw new RuntimeException("没空实现 先不写");
    }

    public void setEditMode(boolean editMode) {
        if (this.editMode == editMode) {
            return;
        }
        this.editMode = editMode;
        notifyDataSetChanged();
    }

    public class ViewHolder extends ClickableAdapter.ViewHolder {

        private final ImageView coverImg;
        private final TextView titleTv;
        private final ImageView editHintImg;

        private FunctionItem data;

        public ViewHolder(final View itemView) {
            super(itemView);
            coverImg = ((ImageView) itemView.findViewById(R.id.coverImg));
            titleTv = ((TextView) itemView.findViewById(R.id.titleTv));
            editHintImg = ((ImageView) itemView.findViewById(R.id.editHintImg));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data != null) {
                        data.getAction().action(itemView.getContext());
                    }
                }
            });
        }

        public void bindData(final FunctionItem data) {
            this.data = data;

            coverImg.setImageResource(data.getIconResId());
            titleTv.setText(data.getName());
            editHintImg.setVisibility(editMode ? View.VISIBLE : View.GONE);
        }
    }
}
