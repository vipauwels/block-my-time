package com.pauwelsvi.blockmytime.timeblocks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pauwelsvi.blockmytime.R;
import com.pauwelsvi.blockmytime.common.AbstractRecyclerAdapter;
import com.pauwelsvi.blockmytime.models.TimeBlock;

public class TimeBlocksdAdapter extends AbstractRecyclerAdapter<TimeBlock> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_block_list_item, parent, false);
        return new TimeBlockListItem(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TimeBlockListItem) holder).setData(getItem(position));
    }

}
