package com.example.sayone.testone.app.homepage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayone.testone.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridAdapter extends ArrayAdapter {

    private Context mContext;
    private List<Integer> mThumbIds = new ArrayList<>(Arrays.asList(

            R.drawable.logone, R.drawable.logtwo,
            R.drawable.logthree, R.drawable.logfive,
            R.drawable.logfive, R.drawable.logseven,
            R.drawable.logone, R.drawable.logfive,
            R.drawable.logfive, R.drawable.logthree,
            R.drawable.logone, R.drawable.logthree,
            R.drawable.logfive, R.drawable.logfive,
            R.drawable.logfive, R.drawable.logone,
            R.drawable.logthree, R.drawable.logthree,
            R.drawable.logfive, R.drawable.logfive,
            R.drawable.logfive, R.drawable.logthree));

    private List<String> mNamesArray = new ArrayList<>(Arrays.asList(
            "1", "2",
            "3", "4",
            "5", "6",
            "7", "8",
            "9", "10",
            "11", "12",
            "13", "14",
            "15", "16",
            "17", "18",
            "19", "20",
            "21", "22"

    ));

    private GridAdapter gridAdapter = this;


    public GridAdapter(Context context) {
        super(context, R.layout.single_grid_custom_design);
        mContext = context;
    }


    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ImageView imageView, menue_img;

        TextView textView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_grid_custom_design, null);
            textView = (TextView) convertView.findViewById(R.id.gridtext);
            imageView = (ImageView) convertView.findViewById(R.id.gridimg);
            menue_img = (ImageView) convertView.findViewById(R.id.menue_icon);

            final ViewHolder holder = new ViewHolder(textView, imageView, menue_img);
            convertView.setTag(holder);

        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.textView.setText(mNamesArray.get(position));
        holder.imageView.setImageResource(mThumbIds.get(position));
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.imageView.setPadding(8, 8, 8, 8);

        holder.menue_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu menu = new PopupMenu(mContext, v);
                menu.getMenuInflater().inflate(R.menu.menu, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        removeItems(position);
                        gridAdapter.notifyDataSetChanged();
                        Toast.makeText(mContext, "deleted", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                menu.show();
            }
        });
        return convertView;
    }

    private void removeItems(int pos) {
        mThumbIds.remove(pos);
        mNamesArray.remove(pos);
    }

    // creating a view holder for the grid elements
    private class ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        private final ImageView menue_img;

        public ViewHolder(TextView textView, ImageView imageView, ImageView menue_img) {
            this.textView = textView;
            this.imageView = imageView;
            this.menue_img = menue_img;
        }
    }
}
