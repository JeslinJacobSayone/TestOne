package com.example.sayone.testone;

public class Person {

    public  static String fname, lname, email, ph, user, pass;

    public void  setperson(String fname, String lname, String email, String ph, String user, String pass) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.ph = ph;
        this.user = user;
        this.pass = pass;
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
}
