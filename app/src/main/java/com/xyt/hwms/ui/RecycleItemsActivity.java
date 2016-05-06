package com.xyt.hwms.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.xyt.hwms.R;
import com.xyt.hwms.adapter.OutboundItemsAdapter;
import com.xyt.hwms.adapter.RecycleItemsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleItemsActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView listview;
    private List<Integer> list = new ArrayList<>();
    private RecycleItemsAdapter recycleItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_items);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list.add(1);
        list.add(1);
        if (recycleItemsAdapter == null) {
            recycleItemsAdapter = new RecycleItemsAdapter(context, list);
        }
        listview.setAdapter(recycleItemsAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}