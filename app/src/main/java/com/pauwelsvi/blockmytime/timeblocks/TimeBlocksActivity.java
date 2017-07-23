package com.pauwelsvi.blockmytime.timeblocks;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.pauwelsvi.blockmytime.R;
import com.pauwelsvi.blockmytime.common.AbstractBaseActivity;
import com.pauwelsvi.blockmytime.db.CupboardSQLiteOpenHelper;
import com.pauwelsvi.blockmytime.db.QueryUtils;
import com.pauwelsvi.blockmytime.models.TimeBlock;
import nl.qbusict.cupboard.QueryResultIterable;

import java.util.List;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class TimeBlocksActivity extends AbstractBaseActivity {

    private final static int ACTION_CREATE_TIME_BLOCK = 12;

    private static SQLiteDatabase db;
    private TimeBlocksdAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.time_blocks);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CupboardSQLiteOpenHelper dbHelper = new CupboardSQLiteOpenHelper(this);
        db = dbHelper.getWritableDatabase();

        RecyclerView list = (RecyclerView) findViewById(R.id.time_block_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        list.setLayoutManager(layoutManager);
        adapter = new TimeBlocksdAdapter();
        adapter.setItems(getTimeBlocks());
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTimeBlock();
            }
        });
    }

    private List<TimeBlock> getTimeBlocks() {
        QueryResultIterable<TimeBlock> iter = cupboard().withDatabase(db).query(TimeBlock.class).query();
        return QueryUtils.getListFromQueryResultIterator(iter);
    }

    private void refresh() {
        adapter.setItems(getTimeBlocks());
    }

    private void createTimeBlock() {
        Intent intent = new Intent(this, TimeBlockCreateActivity.class);
        startActivityForResult(intent, ACTION_CREATE_TIME_BLOCK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTION_CREATE_TIME_BLOCK && resultCode == RESULT_OK) {
            cupboard().withDatabase(db).put(data.getSerializableExtra("time_block"));
            refresh();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
