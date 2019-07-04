package com.example.android.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class IntroActivity extends AppCompatActivity {
    private static int SPLASH_TIME = 4000;
    Random rand = new Random();
    int n = rand.nextInt(3);
    Integer [] animations;
    LottieAnimationView mlottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);
        mlottie = findViewById(R.id.animation_view);
        animations = new Integer[]{R.raw.rotateloading, R.raw.ninjafloating,R.raw.colorful,R.raw.bouncingcoloredball};
        mlottie.setAnimation(animations[n]);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mintent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(mintent);
                finish();
            }
        }, SPLASH_TIME);
    }
    public void restartApp(){
        Intent myintent = new Intent(this , IntroActivity.class);
        startActivity(myintent);
        finish();
    }
}
