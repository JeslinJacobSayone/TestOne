package com.example.sayone.testone;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.sayone.testone.R.drawable.ic_error;

public class RegFrag extends Fragment{



    private OnFragmentInteractionListener mListener;

    public RegFrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RegFrag newInstance(String param1, String param2) {
        RegFrag fragment = new RegFrag();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reg, container, false);
        final EditText fname, lname , email , ph , user , pass , con_pass;
        final TextView dob;
        ImageView ok_button;

        fname =view.findViewById(R.id.reg_fname);
        lname =view.findViewById(R.id.reg_lname);
        email =view.findViewById(R.id.reg_email);
        ph =view.findViewById(R.id.reg_ph);
        user =view.findViewById(R.id.reg_user);
        pass =view.findViewById(R.id.reg_pass);
        con_pass =view.findViewById(R.id.reg_conf_pass);
        dob =view.findViewById(R.id.dob);
        ok_button =view.findViewById(R.id.submit_register);

        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int validation_flag=1;
                String fnameStr, lnameStr , emailStr , phStr , userStr , passStr , con_passStr , dobStr;

                fnameStr = fname.getText().toString().trim();
                lnameStr = lname.getText().toString().trim();
                emailStr = email.getText().toString().trim();
                phStr = ph.getText().toString().trim();
                userStr = user.getText().toString().trim();
                passStr = pass.getText().toString().trim();
                con_passStr = con_pass.getText().toString().trim();
                dobStr=dob.getText().toString().trim();


                Pattern namePattern=Pattern.compile("[A-Za-z]{1,10}");
                Pattern emailPattern = Pattern.compile("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?");
                Pattern phPattern=Pattern.compile("^[7-9][0-9]{9}$");
                Pattern userPattern=Pattern.compile("^[a-z0-9_-]{6,14}$");

                Matcher nameMatch = namePattern.matcher(fnameStr);
                Matcher lastMatch = namePattern.matcher(lnameStr);
                Matcher emailMatch = emailPattern.matcher(emailStr);
                Matcher phMatch = phPattern.matcher(phStr);
                Matcher userMatch = userPattern.matcher(userStr);

                Drawable error = getResources().getDrawable(R.drawable.ic_error);
                error.setBounds(0, 0, error.getIntrinsicWidth(), error.getIntrinsicHeight());



                if(!nameMatch.matches()){
                    validation_flag=0;

                    fname.setError("invalid name",error);
                }
                if(!lastMatch.matches()){
                    validation_flag=0;

                    lname.setError("invalid last name",error);
                }
                if(!emailMatch.matches()){
                    validation_flag=0;

                    email.setError("invalid email",error);
                }
                if(!phMatch.matches()){
                    validation_flag=0;

                    ph.setError("invalid phone",error);

                }
                if(!userMatch.matches()){
                    validation_flag=0;

                    user.setError("username should contain numbers and alphabets",error);
                }
                if(!passStr.equals(con_passStr)){
                    validation_flag=0;
                    Toast.makeText(getContext(), "passwords don't match", Toast.LENGTH_SHORT).show();
                }

                if(validation_flag==1){
                    Person person = new Person();
                    person.setperson(fnameStr,lnameStr,emailStr,phStr,userStr,passStr);
                    Toast.makeText(getContext(), " trying something : "+person.getFname(), Toast.LENGTH_SHORT).show();
                }


            }
        });



        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



}
