package com.example.sayone.testone.app.settings;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sayone.testone.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Fragment fragment = new SettingsFrag();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.settings_container,fragment);
        transaction.commit();

    }

    public static class SettingsFrag extends PreferenceFragment{
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_pref);
        }
    }
}
