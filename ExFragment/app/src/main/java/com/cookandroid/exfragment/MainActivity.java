package com.cookandroid.exfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_a, fragmentA);
        fragmentTransaction.replace(R.id.container_b, fragmentB);
        fragmentTransaction.commit();
    }

    @Override
    public void onInputASent(CharSequence input) { //ok버튼 onclick
        fragmentB.updateEditTextB(input); //A로 넘어온게 B에 반영
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateEditTextA(input);
    }
}
