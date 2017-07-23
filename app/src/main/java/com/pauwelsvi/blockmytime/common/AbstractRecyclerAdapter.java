package com.pauwelsvi.blockmytime.common;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRecyclerAdapter<T> extends RecyclerView.Adapter {

    protected List<T> items = new ArrayList<>();

    public void setItems(List<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int position) {
        return items.get(position);
    }
}
