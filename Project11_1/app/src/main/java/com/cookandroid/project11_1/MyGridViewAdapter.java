package com.cookandroid.project11_1;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridViewAdapter extends BaseAdapter {
    private Context context;

    public MyGridViewAdapter(Context c){
        context = c;
    }

    private Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
            R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

    @Override
    public int getCount() { //그리드에 포함된 아이템(영화 포스터)의 총 수
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
    public View getView(int position, View view, ViewGroup viewGroup) { //그리드 격자구조 각각의 칸에 대하여 호출
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); //격자 구조 중앙에
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[position]);

        final int pos = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = (View) View.inflate(context,R.layout.dialog,null);
                AlertDialog.Builder dIg = new AlertDialog.Builder(context);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dIg.setTitle("큰 포스터");
                dIg.setIcon(R.drawable.movie_icon);
                dIg.setView(dialogView);
                dIg.setNegativeButton("닫기",null);
                dIg.show();
            }
        });
        return imageView;
    }
}
