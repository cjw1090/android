package com.cookandroid.frag111;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    private EditText editText;
    //private MainActivity activity;

    private FragmentAListener listener = null;  //main Activity

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    public interface FragmentAListener {
        void onInputASent(CharSequence input);
    }


    @Override
    public void onAttach(Context context) { //메인액티비티에 attach될때 context = main attach된거
        super.onAttach(context);

        if (context instanceof FragmentAListener) { //메인에 구현되어 있는지 확인
            listener = (FragmentAListener) context; //메인액티비티가 fragment main리스너로 등록

        }else {
            throw new RuntimeException(context.toString() + " must implement FragmentAListener");
        }

    }
/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            String input2= bundle.getString("input");
            editText.setText(input2);
        }

    }

 */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        editText = (EditText) v.findViewById(R.id.fragA1);
        //Bundle bundle = getArguments();
       // String text = bundle.getString("input");
        //editText.setText(text);
        return v;
    }

    public void updateEditTextA(CharSequence newText) {
        editText.setText(newText);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener =null;
    }


}
