package com.cookandroid.ex13_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar1, seekBar2;
        final Button btn;

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        btn = (Button) findViewById(R.id.button1);

        final TextView tv1, tv2;
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                for (int i =0; i <100; i++){
                    seekBar1.setProgress(seekBar1.getProgress() +2);
                    seekBar2.setProgress(seekBar2.getProgress() +1);
                    SystemClock.sleep(100);
                }

                 */
                new Thread() { // for seekBar1
                    public void run() {
                        for(int i=seekBar1.getProgress(); i <100; i=i+2){
                          //seekBar1.setProgress(seekBar1.getProgress() +2);
                          //tv1.setText("Progress of SB1 : " + seekBar1.getProgress() + "%");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seekBar1.setProgress(seekBar1.getProgress() +2);
                                    tv1.setText("Progress of SB1 : " + seekBar1.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread() { // for seekBar2
                    public void run() {
                        for(int i=seekBar2.getProgress(); i <100; i=i+1){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seekBar2.setProgress(seekBar2.getProgress() +1);
                                    tv2.setText("Progress of SB1 : " + seekBar2.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });
    }
}
