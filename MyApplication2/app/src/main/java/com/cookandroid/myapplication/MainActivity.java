package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
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

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_movie_vote:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Movie_Vote_Fragment()).commit();
                        break;
                    case R.id.nav_movie_vote_result:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Movie_Vote_Result_Fragment()).commit();
                        break;
                    case R.id.nav_movie_vote_reset:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Movie_Vote_Reset_Fragment()).commit();
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
            //현재 네비케이션 드로우 오픈되어 ㅣㅇㅆ는지
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    public void addVote(int pos) {
    }

    public int[] N_Like() {
        int[] a = new int[1];
        a[0] = 0;
        return a;
    }
}
