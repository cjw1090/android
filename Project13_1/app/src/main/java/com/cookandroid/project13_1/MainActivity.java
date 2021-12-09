package com.cookandroid.project13_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewMP3;
    Button btnPlay, btnStop;
    TextView tvMP3;

    ArrayList<String> mp3List;
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/Music";
    MediaPlayer mPlayer;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1000 :
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mp3List = new ArrayList<String>();

                    File[] listFiles = new File(mp3Path).listFiles(); //파일 목록 얻기
                    for (File file : listFiles){
                        mp3List.add(file.getName()); //파일네임을 mp3lsit에 추가
                    }

                    listViewMP3 = (ListView) findViewById(R.id.listViesMP3);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mp3List);
                    listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                    listViewMP3.setAdapter(adapter);
                    listViewMP3.setItemChecked(0,true);
                    selectedMP3 = mp3List.get(0);

                    listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedMP3 = mp3List.get(i);
                        }
                    });

                    btnPlay = (Button) findViewById(R.id.btnPlay);
                    btnStop = (Button) findViewById(R.id.btnStop);
                    tvMP3 = (TextView) findViewById(R.id.tvMP3);

                    btnPlay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                mPlayer = new MediaPlayer();
                                mPlayer.setDataSource(mp3Path +"/"+ selectedMP3);
                                mPlayer.prepare();
                                mPlayer.start();
                                btnPlay.setClickable(false);
                                btnStop.setClickable(true); //stop만 누를수있도록
                                tvMP3.setText("재생 중인 음악 : " + selectedMP3);
                            } catch (IOException e) {

                            }
                        }
                    });

                    btnStop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mPlayer.stop();
                            mPlayer.reset();
                            btnPlay.setClickable(true);
                            btnStop.setClickable(false);
                        }
                    });

                    btnStop.setClickable(false);
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //사용자한테 허용또는 거부 묻는거
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);

    }
}
