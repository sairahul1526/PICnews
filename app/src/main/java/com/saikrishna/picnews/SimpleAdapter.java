package com.saikrishna.picnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private boolean isGrid;

    public SimpleAdapter(Context context, boolean isGrid) {
        layoutInflater = LayoutInflater.from(context);
        this.isGrid = isGrid;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;

        if (view == null) {
                view = layoutInflater.inflate(R.layout.simple_grid_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.text_view);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image_view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Context context = parent.getContext();
        switch (position) {
            case 0:
                if (isGrid == true) {
                    viewHolder.textView.setText("REMOVE");
                    viewHolder.imageView.setImageResource(R.drawable.retrostar);
                    break;
                } else {
                    viewHolder.textView.setText("SAVE");
                    viewHolder.imageView.setImageResource(R.drawable.retrostar);
                    break;
                }
            case 1:
                viewHolder.textView.setText("SHARE");
                viewHolder.imageView.setImageResource(R.drawable.retroshare);
                break;
            default:
                viewHolder.textView.setText("LINK");
                viewHolder.imageView.setImageResource(R.drawable.retroweb);
                break;
        }

        return view;
    }

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}