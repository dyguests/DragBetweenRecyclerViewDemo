package com.fanhl.dragbetweenrecyclerviewdemo.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <CVH>
 */
public abstract class ClickableAdapter<CVH extends ClickableAdapter.ViewHolder> extends RecyclerView.Adapter<CVH> {

    @Deprecated //这个好像没用？不用写到 ClickableAdapter 里?
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView rv, int newState) {
            for (RecyclerView.OnScrollListener listener : mListeners) {
                listener.onScrollStateChanged(rv, newState);
            }
        }

        @Override
        public void onScrolled(RecyclerView rv, int dx, int dy) {
            for (RecyclerView.OnScrollListener listener : mListeners) {
                listener.onScrolled(rv, dx, dy);
            }
        }
    };
    protected List<RecyclerView.OnScrollListener> mListeners = new ArrayList<>();

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(onScrollListener);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        recyclerView.removeOnScrollListener(onScrollListener);
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener listener) {
        mListeners.add(listener);
    }

    public interface OnItemClickListener {
        void onItemClick(int position, ClickableAdapter.ViewHolder holder);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(int position, ClickableAdapter.ViewHolder holder);
    }

    private OnItemClickListener itemClickListener;
    private OnItemLongClickListener itemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.itemLongClickListener = listener;
    }

    @Override
    public void onBindViewHolder(final CVH holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(holder.getAdapterPosition(), holder);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return itemLongClickListener != null && itemLongClickListener.onItemLongClick(holder.getAdapterPosition(), holder);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}