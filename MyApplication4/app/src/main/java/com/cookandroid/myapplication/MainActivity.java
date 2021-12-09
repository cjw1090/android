package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {
    private FragmentMain fragmentMain;
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentMain = new FragmentMain();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag1, fragmentMain);
        fragmentTransaction.commit();
    }
    public void FragChange(String str, Bundle bundle) {
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();
        if(str.equals("A")) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentA.setArguments(bundle);
            fragmentTransaction.replace(R.id.frag1, fragmentA);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (str.equals("B")) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentB.setArguments(bundle);
            fragmentTransaction.replace(R.id.frag1, fragmentB);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (str.equals("C")){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentC.setArguments(bundle);
            fragmentTransaction.replace(R.id.frag1, fragmentC);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }


}
