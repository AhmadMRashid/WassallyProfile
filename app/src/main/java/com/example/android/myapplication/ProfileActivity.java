package com.example.android.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class ProfileActivity extends AppCompatActivity {
    Button callButton,emailButton;
    TextView phonetext,email;
    public SharedPrefNightMode sharedPrefNightMode;
    private Switch nightSwitch;
    TextView favouriteText;
    LottieAnimationView favourite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPrefNightMode = new SharedPrefNightMode(this);
        checkNightMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        email = findViewById(R.id.emailstring);
        phonetext = findViewById(R.id.stringPhone);
        callButton = findViewById(R.id.call);
        emailButton = findViewById(R.id.email);
        nightSwitch = findViewById(R.id.nightSwitch2);


        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence csemail = email.getText();
                String [] emailAddress = {csemail.toString()};
             Toast toast =   Toast.makeText(getApplicationContext(),"Choose an email app",Toast.LENGTH_SHORT);
                toast.show();
                composeEmail(emailAddress,"Wassally : *Type your subject*");
            }
        });


        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence csphone = phonetext.getText();
                String PhoneNumber = csphone.toString();
                dialPhoneNumber(PhoneNumber);
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




    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto: "));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject );
        intent.putExtra(Intent.EXTRA_TEXT, "*Type your message here*");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }



    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }








    public void restartApp () {
        Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(i);
        finish();
    }
    public void checkNightMode(){if(sharedPrefNightMode.loadNightModeState()==true) {
        setTheme(R.style.darktheme);
    }
    else  setTheme(R.style.AppTheme);}
}




