package com.example.sayone.testone.AllFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sayone.testone.AdaptersAndClasses.ClickAnims;
import com.example.sayone.testone.HomePage;
import com.example.sayone.testone.AdaptersAndClasses.Person;
import com.example.sayone.testone.R;

public class LoginFrag extends Fragment {


    public LoginFrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LoginFrag newInstance(String param1, String param2) {
        LoginFrag fragment = new LoginFrag();

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    EditText usertxt , passwordtxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        ImageView oksubmit= view.findViewById(R.id.img_ok);
        usertxt = view.findViewById(R.id.login_email);
        passwordtxt = view.findViewById(R.id.login_password);

        oksubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClickAnims anims = new ClickAnims(getContext());
                anims.animate(v);
                String userSTR , passSRT;
                Person person = new Person();
           
                userSTR=usertxt.getText().toString().trim();
                passSRT=passwordtxt.getText().toString().trim();

                if((userSTR.equals(person.getEmail()))&&(passSRT.equals(person.getPass()))){

                    Toast.makeText(getContext(), "login success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),HomePage.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(getContext(), "login fail", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }




}