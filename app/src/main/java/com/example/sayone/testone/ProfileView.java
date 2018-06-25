package com.example.sayone.testone;

import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.sayone.testone.AdaptersAndClasses.ClickAnims;
import com.example.sayone.testone.AdaptersAndClasses.Person;

public class ProfileView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        getSupportActionBar().setTitle("My account");
        final Person person = new Person();

        TextView name, email,ph,dob,user,pass;
        name=findViewById(R.id.profile_name);
        email=findViewById(R.id.profile_email);
        ph=findViewById(R.id.profile_phone);
        dob=findViewById(R.id.profile_dob);
        user=findViewById(R.id.profile_username);
        pass=findViewById(R.id.profile_password);

        name.setText("Name : "+person.getFname()+" "+person.getLname());
        email.setText("Email : "+person.getEmail());
        ph.setText("phone : "+person.getPh());
        dob.setText("Dob : "+person.getDob());
        user.setText("Usename : "+person.getUser());
        pass.setText("Password : "+person.getPass());

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_up);
                v.startAnimation(a);
                Vibrator vibr = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);
                vibr.vibrate(100);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { person.getEmail() });
                intent.putExtra(Intent.EXTRA_SUBJECT, "simple email");
                intent.putExtra(Intent.EXTRA_TEXT, "this is a simple mail body , make apropreate changes here");
                startActivity(Intent.createChooser(intent, "SimpleMail"));
            }
        });

        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClickAnims anims = new ClickAnims(getApplicationContext());
                anims.animate(v);

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+person.getPh()));
                startActivity(intent);
            }
        });

    }
}
