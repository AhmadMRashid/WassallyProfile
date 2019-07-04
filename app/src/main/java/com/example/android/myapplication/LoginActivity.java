package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    public SharedPrefNightMode sharedPrefNightMode;

    private Switch nightSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPrefNightMode = new SharedPrefNightMode(this);
        checkNightMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.buttonLogin);
        nightSwitch= findViewById(R.id.nightSwitch);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(LoginActivity.this, SliderActivity.class);
                startActivity(mintent);
            }
        });

        if (sharedPrefNightMode.loadNightModeState()==true) {
            nightSwitch.setChecked(true);
        }
        nightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedPrefNightMode.setNightModeState(true);
                    restartApp();
                }
                else {
                    sharedPrefNightMode.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }



    public void restartApp () {
        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
        finish();
    }
    public void checkNightMode(){if(sharedPrefNightMode.loadNightModeState()==true) {
        setTheme(R.style.darktheme);
    }
    else  setTheme(R.style.AppTheme);}
}








