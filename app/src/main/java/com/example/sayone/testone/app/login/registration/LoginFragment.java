package com.example.sayone.testone.app.login.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sayone.testone.app.TestApplicationClass;
import com.example.sayone.testone.app.homepage.HomePageActivity;
import com.example.sayone.testone.model.Utilities;
import com.example.sayone.testone.model.Person;
import com.example.sayone.testone.R;

public class LoginFragment extends Fragment {

    EditText mUser_et, mPassword_et;

    public LoginFragment() {   // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ImageView oksubmit = view.findViewById(R.id.img_ok);
        mUser_et = view.findViewById(R.id.login_email);
        mPassword_et = view.findViewById(R.id.login_password);

        oksubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Utilities anims = new Utilities(getContext());
                anims.animate(v);
                String userSTR, passSRT;


                userSTR = mUser_et.getText().toString().trim();
                passSRT = mPassword_et.getText().toString().trim();

                if ((userSTR.equals(TestApplicationClass.getApp().getPersonEmail()))
                        && (passSRT.equals(TestApplicationClass.getApp().getPersonPass()))) {

                    Toast.makeText(getContext(), "login success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), HomePageActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getContext(), "login fail", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }


}
