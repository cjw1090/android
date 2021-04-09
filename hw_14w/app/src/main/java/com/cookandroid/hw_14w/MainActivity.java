package com.cookandroid.hw_14w;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    SeekBar pbMp3;
    Switch switch1;
    MediaPlayer mPlayer;
    TextView tvProgress;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/Music";
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    File file = new File(mp3Path);

                    switch1 = (Switch) findViewById(R.id.switch1);
                    pbMp3 = (SeekBar) findViewById(R.id.pbMP3);
                    tvProgress = (TextView) findViewById(R.id.tvTime);

                    switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                            try {
                                if (isChecked) {
                                    Toast.makeText(getApplicationContext(), "song1 재생 중", Toast.LENGTH_SHORT).show();
                                    mPlayer = new MediaPlayer();
                                    mPlayer.setDataSource(mp3Path +"/song1.mp3");
                                    mPlayer.prepare();
                                    mPlayer.start();

                                    new Thread() {
                                        SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
                                        public void run(){
                                            pbMp3.setMax(mPlayer.getDuration());

                                            while(mPlayer.isPlaying()) {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        pbMp3.setProgress(mPlayer.getCurrentPosition());
                                                        tvProgress.setText("진행시간 : " +timeFormat.format(mPlayer.getCurrentPosition()));
                                                    }
                                                });
                                            }
                                        }
                                    }.start();
                                }else {
                                    mPlayer.stop();
                                    mPlayer.reset();
                                    Toast.makeText(getApplicationContext(), "중지", Toast.LENGTH_SHORT).show();
                                }
                            }catch (IOException e){

                            }

                        }
                    });
                    pbMp3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            if (fromUser) {
                                mPlayer.seekTo(progress);
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
    }
}
