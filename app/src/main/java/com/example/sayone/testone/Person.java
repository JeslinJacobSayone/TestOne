package com.example.sayone.testone;

public class Person {

    public  static String fname, lname, email, ph, user, pass , dob;

    public void  setperson(String fname, String lname, String email, String ph, String user, String pass , String dob) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.ph = ph;
        this.user = user;
        this.pass = pass;
        this.dob=dob;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPh() {
        return ph;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getDob() {
        return dob;
    }
}
