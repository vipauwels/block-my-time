package com.pauwelsvi.blockmytime.timeblocks;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.pauwelsvi.blockmytime.R;
import com.pauwelsvi.blockmytime.models.TimeBlock;

import java.util.concurrent.TimeUnit;

public class TimeBlockListItem extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView time;

    public TimeBlockListItem(View view) {
        super(view);

        title = (TextView) view.findViewById(R.id.title);
        time = (TextView) view.findViewById(R.id.time);
    }

    public void setData(TimeBlock timeBlock) {
        title.setText(timeBlock.getTitle());
        time.setText(String.valueOf(String.format("%d minutes", TimeUnit.MILLISECONDS.toMinutes(timeBlock.getTime()))));
    }
}
