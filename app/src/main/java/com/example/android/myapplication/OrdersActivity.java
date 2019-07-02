package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrdersActivity extends AppCompatActivity {
    Button button_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
       button_profile = findViewById(R.id.button_profile);
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileIntent();
            }
        });
    }


    public void profileIntent() {
        Intent intennt = new Intent ( OrdersActivity.this, ProfileActivity.class );
        startActivity ( intennt );}
}
