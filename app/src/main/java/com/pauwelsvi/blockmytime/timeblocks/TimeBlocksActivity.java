package com.pauwelsvi.blockmytime.timeblocks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.pauwelsvi.blockmytime.R;
import com.pauwelsvi.blockmytime.common.AbstractBaseActivity;
import com.pauwelsvi.blockmytime.models.TimeBlock;

import java.util.ArrayList;
import java.util.List;

public class TimeBlocksActivity extends AbstractBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.time_blocks);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView list = (RecyclerView) findViewById(R.id.time_block_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        list.setLayoutManager(layoutManager);
        TimeBlocksdAdapter adapter = new TimeBlocksdAdapter();
        adapter.setItems(getTimeBlocks());
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeblocks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List<TimeBlock> getTimeBlocks(){
        List<TimeBlock> result = new ArrayList<>();

        result.add(new TimeBlock("Ménage", 1200000));
        result.add(new TimeBlock("Sport", 900000));
        result.add(new TimeBlock("Silence", 600000));

        return result;
    }
}
