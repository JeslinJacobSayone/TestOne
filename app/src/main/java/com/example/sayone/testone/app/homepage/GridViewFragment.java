package com.example.sayone.testone.app.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.sayone.testone.R;


public class GridViewFragment extends Fragment {


    public GridViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_grid_view, container, false);
        GridView gridview = (GridView) view.findViewById(R.id.gridview);
//        GridImageAdapter adapter = new GridImageAdapter(getContext());
        GridAdapter adapter = new GridAdapter(getContext());

        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), WebActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
