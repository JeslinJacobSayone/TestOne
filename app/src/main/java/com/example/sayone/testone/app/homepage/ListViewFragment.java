package com.example.sayone.testone.app.homepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sayone.testone.R;
import com.example.sayone.testone.model.ImageListModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends Fragment {

    List<ImageListModel> mitemList;
    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list_view, container, false);

        final RecyclerView recyclerView = view.findViewById(R.id.image_list_recycler);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        mitemList = new ArrayList<>();
        initializeData();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mitemList,getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initializeData(){
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logone ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logtwo ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logthree ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logfor ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logfive ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logone ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logtwo ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logthree ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logfor ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logfive ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logone ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logtwo ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logthree ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logfor ),"This is first image"));
        mitemList.add(new ImageListModel(getResources().getDrawable( R.drawable.logfive ),"This is first image"));

    }



}
