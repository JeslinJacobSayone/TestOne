package com.example.sayone.testone.app.login.registration;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabSwipePagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private Fragment[] mFragments;

    public TabSwipePagerAdapter(FragmentManager fm, Fragment[] fragmentArray) {
        super(fm);
        this.mFragments=fragmentArray;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }
}