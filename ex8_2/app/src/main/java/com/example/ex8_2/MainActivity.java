package com.example.ex8_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrew, btnNext;
    myPictureView myPictureView;
    int curNum;
    File[] imageFiles;
    String imageFname;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1000:
                if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    //imageFiles = new File("/storage/emulated/0/Pictures").listFiles();
                    imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
                    curNum =0;
                    imageFname = imageFiles[0].toString();
                    myPictureView.imagePath = imageFname;
                    myPictureView.invalidate();

                    btnPrew.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(curNum <=0){
                                Toast.makeText(MainActivity.this, "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                curNum--;
                                imageFname= imageFiles[curNum].toString();
                                myPictureView.imagePath = imageFname;
                                myPictureView.invalidate();
                            }
                        }
                    });
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (curNum >= imageFiles.length-1) { //현재 화면상 파일은 갸ㅏ장마지막 파일
                                Toast.makeText(MainActivity.this, "마지막 그림입니다",Toast.LENGTH_SHORT).show();
                            } else  {
                                curNum++;
                                imageFname = imageFiles[curNum].toString();
                                myPictureView.imagePath = imageFname;
                                myPictureView.invalidate();
                            }
                        }
                    });
                }
        }
  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1000);
        btnPrew = (Button) findViewById(R.id.btnPrew);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPictureView = (myPictureView) findViewById(R.id.myPictureView);
  }
}
