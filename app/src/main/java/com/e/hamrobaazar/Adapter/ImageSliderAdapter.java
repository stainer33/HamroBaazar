package com.e.hamrobaazar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.e.hamrobaazar.R;

public class ImageSliderAdapter extends PagerAdapter {

    private int [] imageFiles;
    private Context context;
    private LayoutInflater layoutInflater;

    public ImageSliderAdapter(int[] imageFiles, Context context) {
        this.imageFiles = imageFiles;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageFiles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slider_layout,container,false);
        ImageView imageView=view.findViewById(R.id.image_view);
        imageView.setImageResource(imageFiles[position]);
       container.addView(view);
       return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);

    }
}
