package com.pauwelsvi.blockmytime.timeblocks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import com.pauwelsvi.blockmytime.R;
import com.pauwelsvi.blockmytime.common.AbstractBaseActivity;
import com.pauwelsvi.blockmytime.models.TimeBlock;

import java.util.concurrent.TimeUnit;

public class TimeBlockCreateActivity extends AbstractBaseActivity implements OnKeyListener {

    private TextView taskNameTv;
    private TextView durationTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.time_block_create);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskNameTv = (TextView) findViewById(R.id.task_name);
        durationTv = (TextView) findViewById(R.id.duration);
        taskNameTv.setOnKeyListener(this);
        durationTv.setOnKeyListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        if (validateForm()) {
            menu.add(1, 1, 1, "OK").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == 1) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("time_block", new TimeBlock(getTaskName(), TimeUnit.MINUTES.toMillis(getDuration())));
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean validateForm() {
        return !getTaskName().isEmpty() && getDuration() > 0l;
    }

    private String getTaskName() {
        return taskNameTv.getText().toString();
    }

    private long getDuration() {
        try {
            return Long.parseLong(durationTv.getText().toString());
        } catch(Exception e) {
            return 0l;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        invalidateOptionsMenu();
        return false;
    }

}
