package com.cookandroid.project11_2;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGalleryAdapter extends BaseAdapter {
    Context context;
    public MyGalleryAdapter(Context c){
        context = c;
    }

    private Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
            R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,};

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); //격자 구조 중앙에
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[position]);

        final int pos = position;
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageView ivPoster = (ImageView) ((MainActivity)context).findViewById(R.id.ivPoster);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setImageResource(posterID[pos]);
                return false;
            }
        });
        return imageView;
    }
}
