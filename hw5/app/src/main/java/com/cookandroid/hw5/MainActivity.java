package com.cookandroid.hw5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    SQLiteDatabase sqlDB;
    MyDBHelper myDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        //actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true); //왼쪽 가장자리 홈바
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        myDBHelper = new MyDBHelper(MainActivity.this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_vote :
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Vote()).commit();
                        //sqlDB = myDBHelper.getWritableDatabase();
                        break;
                    case R.id.nav_voteResult :
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Vote_Result()).commit();
                        break;
                    case R.id.nav_voteReset :
                        sqlDB = myDBHelper.getWritableDatabase();
                        myDBHelper.onUpgrade(sqlDB, 1,2);
                        sqlDB.close();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Vote_Reset()).commit();
                        break;

                }
                drawer.closeDrawer(GravityCompat.START);
                return true; //선택되었을 때 true 리턴
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            //현재 네비케이션 드로우 오픈되어 있는지
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context) {
            super(context, "movieDB", null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE movieTBL ( mName CHAR(20) PRIMARY KEY, Likes INTEGER ); ");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목1', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목2', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목3', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목4', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목5', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목6', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목7', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목8', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목9', 0 );");
            sqLiteDatabase.execSQL("INSERT INTO movieTBL (mName, Likes) VALUES ('제목10', 0 );");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS movieTBL"); //있으면 삭제 후 재생성
            onCreate(sqLiteDatabase);
        }


    }
    public void addVote(int position){
        int pos = position+1;
        String sqlUpdate = "UPDATE movieTBL SET Likes=Likes+1 WHERE mName = '제목"+pos+"'";
        //System.out.println(sqlUpdate);
        sqlDB = myDBHelper.getWritableDatabase();
        sqlDB.execSQL(sqlUpdate);
    }

    public void voteRes(TextView tv[], RatingBar rbar[]){
        sqlDB = myDBHelper.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("SELECT * FROM movieTBL;", null);
        int[] voteResult = new int[10];
        String[] imageName = new String[10];
        int i=0;
        while(cursor.moveToNext()) {
            imageName[i] = cursor.getString(0);
            voteResult[i] = cursor.getInt(1);
            i++;
        }

        for(i=0; i<10; i++ ){
            tv[i].setText(imageName[i]);
            rbar[i].setRating(voteResult[i]);
            //System.out.println(voteResult[i]);
        }
        //rbar[2].setRating(3);
    }

    int[] NL = new int[10];
    public int[] N_Like(){
        sqlDB = myDBHelper.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("SELECT Likes FROM movieTBL;", null);

        int i=0;
        while(cursor.moveToNext()){
            NL[i] = cursor.getInt(0);
            i++;
        }
        for(i=0; i<10; i++){
            System.out.println("NL값 : "+i+ NL[i]);
        }

        return NL;
    }

    public void voteRe(EditText edtNameResult, EditText edtNumberResult) {

        sqlDB = myDBHelper.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("SELECT * FROM movieTBL;", null);

        String strNames = "제목" + "\r\n" + "--------" + "\r\n";
        String strNumbers = "선호도" + "\r\n" + "--------" + "\r\n";
        while (cursor.moveToNext()) {
            strNames += cursor.getString(0) + "\r\n";
            strNumbers  += cursor.getString(1) + "\r\n";
        }

        edtNameResult.setText(strNames);
        edtNumberResult.setText(strNumbers);

        cursor.close();
        sqlDB.close();
    }
}
