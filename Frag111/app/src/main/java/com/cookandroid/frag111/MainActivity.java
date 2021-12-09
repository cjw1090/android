package com.cookandroid.frag111;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private FragmentMain fragmentMain;
    FragmentA fragmentA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.Fragment_A);

        fragmentMain = new FragmentMain();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_main,fragmentMain);
        fragmentTransaction.commit();

        //Bundle b = getIntent().getExtras();
        //FragmentA fa = new FragmentA();
        //fa.updateEditTextA(b);
        //ragmentA = new FragmentA();
    }

    public void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.container_main, fragment).commit();

        //Bundle bundle = new Bundle();
        //bundle.putString("input", text);
    }




}
