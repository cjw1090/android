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

public class FragmentB extends Fragment {
    private EditText editText;
    private FragmentBListener listener = null;  //main Activity


    public static FragmentB newInstance() {
        return new FragmentB();
    }

    public interface FragmentBListener {
        void onInputCSent(CharSequence input);
    }
/*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentBListener) { //메인에 구현되어 있는지 확인
            listener = (FragmentBListener) context;
        }else {
            throw new RuntimeException(context.toString() + " must implement FragmentAListener");
        }
    }
*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        editText = (EditText) v.findViewById(R.id.fragB);

        return v;
    }
    public void updateEditTextB(CharSequence newText) {
        editText.setText(newText);
    }


}
