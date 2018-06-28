package com.example.sayone.testone.model;

public class Person {

    private String mFname, mLastName, mEmail, mPhone, mUser, mPass , mDob;

    public void  setperson(String mFname, String mLastName, String mEmail, String mPhone, String mUser, String mPass , String mDob) {
        this.mFname = mFname;
        this.mLastName = mLastName;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
        this.mUser = mUser;
        this.mPass = mPass;
        this.mDob=mDob;
    }

    public String getFname() {
        return mFname;
    }

    public String getLname() {
        return mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPh() {
        return mPhone;
    }

    public String getUser() {
        return mUser;
    }

    public String getPass() {
        return mPass;
    }

    public String getDob() {
        return mDob;
    }
}
