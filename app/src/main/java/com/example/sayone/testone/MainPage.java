package com.example.sayone.testone;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;


public class MainPage extends AppCompatActivity implements OnFragmentInteractionListener{


    private final String[] PAGE_TITLES = new String[] {
            "Login",
            "Register"
    };

    private final Fragment[] PAGES = new Fragment[] {
            new LoginFrag(),
            new RegFrag()
    };

    ViewPager viewPager;
    EditText dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        for(int i=0;i<PAGE_TITLES.length;i++){

            tabLayout.getTabAt(i).setText(PAGE_TITLES[i]);
        }


    }
    public void pickdate(View v){
        Intent intent = new Intent(this,DialogDate.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(resultCode==RESULT_OK){
                TextView dobtxt=findViewById(R.id.dob);
                dobtxt.setText(data.getStringExtra("DOBselected"));
            }
        }
    }
/*    public void loginclick(View v){
        Person person = new Person();
    }*/

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
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
}
