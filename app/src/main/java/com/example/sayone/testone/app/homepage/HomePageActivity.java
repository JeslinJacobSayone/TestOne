package com.example.sayone.testone.app.homepage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.sayone.testone.R;
import com.example.sayone.testone.app.settings.SettingsActivity;
import com.example.sayone.testone.app.login.registration.MyPagerAdapter;

public class HomePageActivity extends AppCompatActivity {

    ViewPager mViewPager;

    private final String[] PAGE_TITLES = new String[] {
            "Grid Images",
            "List Images"
    };

    private final Fragment[] PAGES = new Fragment[] {
            new GridViewFragment(),
            new ListViewFragment()
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = findViewById(R.id.tabtwotoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.home_title));

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_settings);
        toolbar.setOverflowIcon(drawable);

        mViewPager = findViewById(R.id.home_view_pager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),PAGES));
        TabLayout tabLayout = findViewById(R.id.home_tab);
        tabLayout.setupWithViewPager(mViewPager);
        for(int i=0;i<PAGE_TITLES.length;i++){

            tabLayout.getTabAt(i).setText(PAGE_TITLES[i]);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
