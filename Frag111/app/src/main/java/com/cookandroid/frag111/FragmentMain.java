package com.cookandroid.frag111;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;


public class FragmentMain extends Fragment {
    private EditText edit_text_main;

    private FragmentMainListener listener = null;
    private Button btnA,btnB,btnC;
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    //MainActivity activity;

    public interface FragmentMainListener {
        void onInputMainSentA(CharSequence input);
    }

        @Override
        public void onAttach(Context context) { //메인액티비티에 attach될때 context = main attach된거
            super.onAttach(context);
            if (context instanceof FragmentMainListener) { //메인에 구현되어 있는지 확인
                listener = (FragmentMainListener) context; //메인액티비티가 fragment main리스너로 등록
            }else {
                throw new RuntimeException(context.toString() + " must implement FragmentAListener");
            }

        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        btnA = (Button) v.findViewById(R.id.btnA);
        btnB = (Button) v.findViewById(R.id.btnB);
        btnC = (Button) v.findViewById(R.id.btnC);
        edit_text_main = (EditText) v.findViewById(R.id.edit_text_main);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentA = new FragmentA();
                //fragmentA = (Fragment)
                //activity = (MainActivity) getActivity();
               // CharSequence input = edit_text_main.getText();
                //String text = edit_text_main.getText().toString();
                CharSequence input = edit_text_main.getText();
                //Bundle bundle = new Bundle();
                //String input2 = input.toString();
                //bundle.putString("input", input2);
                //fragmentA.setArguments(bundle);

                //listener.onInputMainSentA(input2);
                ((MainActivity)getActivity()).replaceFragment(FragmentA.newInstance());

                //listener.onInputMainSentA(input);


            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentB = new FragmentB();
                ((MainActivity)getActivity()).replaceFragment(FragmentB.newInstance());
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentC = new FragmentC();
                ((MainActivity)getActivity()).replaceFragment(FragmentC.newInstance());
            }
        });


        return v;
    }
/*
    @Override
    public void onDetach() {
        super.onDetach();
        listener =null;
    }
*/

}


