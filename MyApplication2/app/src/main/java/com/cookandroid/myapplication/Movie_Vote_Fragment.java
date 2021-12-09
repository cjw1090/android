package com.cookandroid.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Movie_Vote_Fragment extends Fragment {
    GridView myGridView;
    private Context mContext;
    int[] NL = new int[10];
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vote,container,false);
        myGridView = (GridView) view.findViewById(R.id.gView1);
        //GridView gridView = (GridView) findViewById(R.id.gridView1);
        //myGridView.setAdapter(new myGridView);
        MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter(mContext);
        myGridView.setAdapter(myGridViewAdapter); //그리드 뷰에 객체 그리드 뷰 디자인 적용
        return view;
    }

    public class MyGridViewAdapter extends BaseAdapter {
        private Context context;
        private int pos1;
        public MyGridViewAdapter(Context c){
            context = c;
        }

        private Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
                R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};
        String[] posterTitle = {"제목1", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7", "제목8", "제목9", "제목10"};
        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return posterID[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); //격자 구조 중앙에
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    NL=((MainActivity)getActivity()).N_Like();
                    final View dialogView = (View) View.inflate(context,R.layout.dialog, null);
                    AlertDialog.Builder dIg = new AlertDialog.Builder(context);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.img1);
                    TextView ivPosterText = (TextView) dialogView.findViewById(R.id.txt1);
                    ImageButton imgBtn = (ImageButton) dialogView.findViewById(R.id.imgBtn);
                    final TextView txtLike = (TextView) dialogView.findViewById(R.id.txtLike);
                    ivPoster.setImageResource(posterID[pos]);
                    ivPosterText.setText(posterTitle[pos]);
                    imgBtn.setBackgroundResource(R.drawable.ic_thumb_up_black_24dp);
                    String NL2 = Integer.toString(NL[pos]);
                    txtLike.setText("Likes : "+NL2); //여기서 숫자 바꾸기

                    imgBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            //여기서 투표 추가

                            ((MainActivity)getActivity()).addVote(pos);
                            NL=((MainActivity)getActivity()).N_Like();
                            for(int i=0;i<10;i++){
                                System.out.println(i+","+NL[i]);
                            }
                            System.out.println(pos+","+NL[pos]);

                            TextView txtLike = (TextView) dialogView.findViewById(R.id.txtLike);
                            txtLike.setText("Likes : "+NL[pos]);


                        }
                    });

                    dIg.setView(dialogView);
                    dIg.setNegativeButton("닫기",null);

                    dIg.show();



                }
            });
            return imageView;
        }

    }

}

