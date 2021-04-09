package com.cookandroid.hw2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPictureView;
    int curNum;
    File[] imageFiles;
    String imageFname;
    TextView text1;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //imageFiles = new File("/storage/emulated/0/Pictures").listFiles();
                    imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
                    curNum = 0;
                    imageFname = imageFiles[0].toString();
                    myPictureView.imagePath = imageFname;
                    myPictureView.invalidate();
                    text1.setText(curNum + 1 + "/" + imageFiles.length);

                    btnPrev.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (curNum <= 0) {
                                //Toast.makeText(MainActivity.this, "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
                                curNum = imageFiles.length - 1;
                            } else {
                                curNum--;
                            }
                            imageFname = imageFiles[curNum].toString();
                            myPictureView.imagePath = imageFname;
                            myPictureView.invalidate();
                            text1.setText(curNum + 1 + "/" + imageFiles.length);
                        }
                    });
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (curNum >= imageFiles.length - 1) { //현재 화면상 파일은 갸ㅏ장마지막 파일
                                //Toast.makeText(MainActivity.this, "마지막 그림입니다", Toast.LENGTH_SHORT).show();
                                curNum = 0;
                            } else {
                                curNum++;
                            }
                            imageFname = imageFiles[curNum].toString();
                            myPictureView.imagePath = imageFname;
                            myPictureView.invalidate();
                            text1.setText(curNum + 1 + "/" + imageFiles.length);
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this, "퍼미션 허용해주세요", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어(변경)");
         /*
        int permissioncheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permissioncheck == PackageManager.PERMISSION_DENIED){

        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                Toast.makeText(MainActivity.this, "퍼미션 허용해주세요", Toast.LENGTH_SHORT).show();
            }
            else{
                ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
            }
        }
        */

        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        text1 = (TextView) findViewById(R.id.text1);
        myPictureView = (myPictureView) findViewById(R.id.myPictureView);
    }
}
