package com.example.sayone.testone.app.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayone.testone.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridImageAdapter extends BaseAdapter {

    private Context mContext;
    private GridImageAdapter gridImageAdapter =this;

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

    private List<String> names=new ArrayList<>(Arrays.asList(
            "1","2",
            "3","4",
            "5","6",
            "7","8",
            "9","10",
            "11","12",
            "13","14",
            "15","16",
            "17","18",
            "19","20",
            "21","22"

    ));

    // Constructor
    public GridImageAdapter(Context c) {
        mContext = c;
    }

//
//    public Integer[] mThumbIds = {
//            R.drawable.logone, R.drawable.logtwo,
//            R.drawable.logthree, R.drawable.logfive,
//            R.drawable.logfive, R.drawable.logseven,
//            R.drawable.logone, R.drawable.logfive,
//            R.drawable.logfive, R.drawable.logthree,
//            R.drawable.logone, R.drawable.logthree,
//            R.drawable.logfive, R.drawable.logfive,
//            R.drawable.logfive, R.drawable.logone,
//            R.drawable.logthree, R.drawable.logthree,
//            R.drawable.logfive, R.drawable.logfive,
//            R.drawable.logfive, R.drawable.logthree
//    };

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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ImageView imageView,menue_img;
        View grid;

        if (convertView == null) {
            LayoutInflater inflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.single_grid_custom_design, null);
        }
        else
        {
            grid = convertView;
        }

        TextView  textView = (TextView) grid.findViewById(R.id.gridtext);
        imageView = (ImageView)grid.findViewById(R.id.gridimg);
        menue_img=(ImageView)grid.findViewById(R.id.menue_icon);

        textView.setText(names.get(position));
        imageView.setImageResource(mThumbIds.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);

        menue_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu menu = new PopupMenu(mContext,v);
                menu.getMenuInflater().inflate(R.menu.menu,menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {


                        mThumbIds.remove(position);
                        names.remove(position);

                        gridImageAdapter.notifyDataSetChanged();
                        Toast.makeText(mContext, "deleted position : "+position, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                menu.show();
            }
        });
        return grid;
    }
}
