package com.cookandroid.project10_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent rxintent = getIntent();
        Bundle extras = rxintent.getExtras();
        int[] voteResult;
        String[] imageName;

        if(extras!= null ){
            voteResult = extras.getIntArray("VoteCount");
            imageName = extras.getStringArray("ImageNames");

            TextView tv[] = new TextView[imageName.length];
            RatingBar rbar[] = new RatingBar[imageName.length];

            Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
            Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                    R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

            for(int i=0; i<imageName.length; i++){
                tv[i] = (TextView) findViewById(tvID[i]);
                rbar[i] = (RatingBar) findViewById(rbarID[i]);
            }

            for(int i=0; i<imageName.length; i++ ){
                tv[i].setText(imageName[i]);
                rbar[i].setRating(voteResult[i]);
            }
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
