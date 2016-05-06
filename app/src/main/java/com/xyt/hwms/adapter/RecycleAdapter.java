package com.xyt.hwms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.xyt.hwms.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Levin on 2016-05-04.
 */
public class RecycleAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<?> list;

    public RecycleAdapter(Context context, List<?> list) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_recycle, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.phonenum)
        TextView phonenum;
        @BindView(R.id.apartment)
        TextView apartment;
        @BindView(R.id.priceRange)
        TextView priceRange;
        @BindView(R.id.recommand)
        Button recommand;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}