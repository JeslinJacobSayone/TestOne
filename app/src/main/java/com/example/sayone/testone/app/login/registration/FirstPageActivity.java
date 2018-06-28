package com.example.sayone.testone.app.login.registration;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.sayone.testone.R;


public class FirstPageActivity extends AppCompatActivity {


    private final String[] mPagetitles = new String[] {
            "Login",
            "Register"
    };

    private final Fragment[] mFragments = new Fragment[] {
            new LoginFragment(),
            new RegistrationFragment()
    };

    ViewPager mViewPager;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mViewPager = findViewById(R.id.viewPager);

        mViewPager.setAdapter(new TabSwipePagerAdapter(getSupportFragmentManager(),mFragments));
        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(mViewPager);
        for(int i=0;i<mPagetitles.length;i++){

            tabLayout.getTabAt(i).setText(mPagetitles[i]);
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


}
