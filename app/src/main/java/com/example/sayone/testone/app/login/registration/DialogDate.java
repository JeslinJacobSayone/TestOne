package com.example.sayone.testone.app.login.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.sayone.testone.R;
import com.example.sayone.testone.model.Utilities;

public class DialogDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_date);

    }

    public void onsubmit(View view){

        Utilities anims = new Utilities(getApplicationContext());
        anims.animate(view);
        DatePicker datePicker = findViewById(R.id.dobpicker);
        String DOB= datePicker.getDayOfMonth()+"-"+datePicker.getMonth()+"-"+datePicker.getYear();
        Intent intent = new Intent();
        intent.putExtra("DOBselected", DOB);
        setResult(RESULT_OK, intent);
        finish();
    }
}
