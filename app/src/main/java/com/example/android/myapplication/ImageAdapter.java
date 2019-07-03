package com.example.android.myapplication;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageAdapter extends PagerAdapter  {
    public int mposition;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private int [] images = new int[] {R.drawable.slider1,R.drawable.slider2,R.drawable.slider3};

    public ImageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container,  int position) {

        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource ( images[ position ] );
        container.addView(imageView, 0);
        return imageView;

    }

    public int getMposition (){

        return mposition;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
