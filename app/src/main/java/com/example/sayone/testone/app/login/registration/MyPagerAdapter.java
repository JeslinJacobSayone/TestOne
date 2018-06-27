package com.example.sayone.testone.app.login.registration;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] PAGES;

    public MyPagerAdapter(FragmentManager fm,Fragment[] PAGES) {
        super(fm);
        this.PAGES=PAGES;
    }

    @Override
    public Fragment getItem(int position) {
        return PAGES[position];
    }

    @Override
    public int getCount() {
        return PAGES.length;
    }
}