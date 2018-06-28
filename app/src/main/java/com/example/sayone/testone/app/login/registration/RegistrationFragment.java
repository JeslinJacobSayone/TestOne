package com.example.sayone.testone.app.login.registration;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayone.testone.app.TestApplicationClass;
import com.example.sayone.testone.model.Utilities;
import com.example.sayone.testone.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationFragment extends Fragment{



    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reg, container, false);
        ImageView ok_button;
        final EditText fName, lName , email , ph , user , pass , conPass;
        final TextView dob;


        fName =view.findViewById(R.id.reg_fname);
        lName =view.findViewById(R.id.reg_lname);
        email =view.findViewById(R.id.reg_email);
        ph =view.findViewById(R.id.reg_ph);
        user =view.findViewById(R.id.reg_user);
        pass =view.findViewById(R.id.reg_pass);
        conPass =view.findViewById(R.id.reg_conf_pass);
        dob =view.findViewById(R.id.dob);
        ok_button =view.findViewById(R.id.submit_register);

        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
                int validationFlag=1;
                String fNameStr, lNameStr,emailStr,phStr,userStr,passStr,con_passStr,dobStr;

                Utilities anims = new Utilities(getContext());
                anims.animate(v);
               
                fNameStr = fName.getText().toString().trim();
                lNameStr = lName.getText().toString().trim();
                emailStr = email.getText().toString().trim();
                phStr = ph.getText().toString().trim();
                userStr = user.getText().toString().trim();
                passStr = pass.getText().toString().trim();
                con_passStr = conPass.getText().toString().trim();
                dobStr=dob.getText().toString().trim();


                Pattern namePattern=Pattern.compile("[A-Za-z]{1,10}");
                Pattern emailPattern = Pattern.compile("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?");
                Pattern phPattern=Pattern.compile("^[7-9][0-9]{9}$");
                Pattern userPattern=Pattern.compile("^[a-z0-9_-]{6,14}$");

                Matcher nameMatch = namePattern.matcher(fNameStr);
                Matcher lastMatch = namePattern.matcher(lNameStr);
                Matcher emailMatch = emailPattern.matcher(emailStr);
                Matcher phMatch = phPattern.matcher(phStr);
                Matcher userMatch = userPattern.matcher(userStr);

                Drawable error = getResources().getDrawable(R.drawable.ic_error);
                error.setBounds(0, 0, error.getIntrinsicWidth(), error.getIntrinsicHeight());



                if(!nameMatch.matches()){
                    validationFlag=0;

                    fName.setError("invalid name",error);
                }
                if(!lastMatch.matches()){
                    validationFlag=0;

                    lName.setError("invalid last name",error);
                }
                if(!emailMatch.matches()){
                    validationFlag=0;

                    email.setError("invalid email",error);
                }
                if(!phMatch.matches()){
                    validationFlag=0;

                    ph.setError("invaliphd phone",error);

                }
                if(!userMatch.matches()){
                    validationFlag=0;

                    user.setError("username should contain numbers and alphabets",error);
                }
                if(dobStr.equals("click to select DOB")){
                    validationFlag=0;
                    Toast.makeText(getContext(), "please select you DOB", Toast.LENGTH_SHORT).show();
                }
                if(!passStr.equals(con_passStr)){
                    validationFlag=0;
                    Toast.makeText(getContext(), "passwords don't match", Toast.LENGTH_SHORT).show();
                }

                if(validationFlag==1){

                    TestApplicationClass.getApp().setPerson(fNameStr,lNameStr,emailStr,phStr,userStr,passStr,dobStr);
//                    ((TestApplicationClass)getActivity().getApplicationContext()).setPerson(fNameStr,lNameStr,emailStr,phStr,userStr,passStr,dobStr);
//                    Person person = new Person();
//                    person.setperson(fNameStr,lNameStr,emailStr,phStr,userStr,passStr,dobStr);
//                    Toast.makeText(getContext(), " registration compleated : "+person.getFname(), Toast.LENGTH_SHORT).show();
                }


            }
        });

        return  view;
    }




}
