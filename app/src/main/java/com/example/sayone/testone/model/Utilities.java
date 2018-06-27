package com.example.sayone.testone.model;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.sayone.testone.R;

public class Utilities {

    Context context;

    public Utilities(Context context){
        this.context=context;
    }

    public void animate(View view){
        Animation a = AnimationUtils.loadAnimation(context, R.anim.scale_up);
        view.startAnimation(a);
        Vibrator vibr = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        vibr.vibrate(100);
    }
}
