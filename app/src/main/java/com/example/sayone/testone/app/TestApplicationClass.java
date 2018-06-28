package com.example.sayone.testone.app;

import android.app.Application;
import android.widget.Toast;


import com.example.sayone.testone.model.Person;

public class TestApplicationClass extends Application {

    private Person mPerson;
    private static TestApplicationClass sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mPerson = new Person();
    }

    public static TestApplicationClass getApp() {
        return sInstance;
    }

    public void setPerson(String fNameStr, String lNameStr, String emailStr,
                          String phStr, String userStr,
                          String passStr, String dobStr) {
        mPerson.setperson(fNameStr, lNameStr, emailStr, phStr, userStr, passStr, dobStr);
        Toast.makeText(this, "hai " + fNameStr, Toast.LENGTH_SHORT).show();
    }

    public String getPersonEmail(){
       return mPerson.getEmail();
    }
    public String getPersonPass(){
        return mPerson.getPass();
    }
}

