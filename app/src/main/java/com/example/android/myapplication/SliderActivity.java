package com.example.android.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SliderActivity extends AppCompatActivity {
    LinearLayout mDotLayout;
    TextView [] mDots;
    private int mCurrentPage=0;
    Button nextButton ;
    Button skipButton ;
    int buttonFlag = 0;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        nextButton = findViewById(R.id.button_next);
        skipButton = findViewById(R.id.button_skip);
        mDotLayout =  findViewById(R.id.dotsLayout);
        final ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setCurrentItem(mCurrentPage);
        viewPager.setAdapter(adapter);
        animationView = findViewById(R.id.animation_view);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               profileIntent();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (buttonFlag == 0){ viewPager.setCurrentItem(mCurrentPage+1);}
               else {profileIntent(); }
            }
        });

        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);
    }


public void profileIntent() {
        Intent intennt = new Intent ( SliderActivity.this, OrdersActivity.class );
    startActivity ( intennt );}

    public  void addDotsIndicator (int position){

        mDots= new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0 ; i <mDots.length ; i ++)
        {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.white));
            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0 ){
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
        addDotsIndicator(i);
        mCurrentPage = i;
        if (i== mDots.length-1){ nextButton.setText("Finish");
        buttonFlag=1;
        animationView.setVisibility(View.GONE);
        }

        else { nextButton.setText("Next"); buttonFlag=0; animationView.setVisibility(View.VISIBLE); }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
