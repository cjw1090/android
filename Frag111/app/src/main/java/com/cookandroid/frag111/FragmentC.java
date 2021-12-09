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

public class FragmentC extends Fragment {
    private EditText editText;
    private FragmentCListener listener = null;  //main Activity


    public static FragmentC newInstance() {
        return new FragmentC();
    }

    public interface FragmentCListener {
        void onInputCSent(CharSequence input);
    }
    /*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCListener) { //메인에 구현되어 있는지 확인
            listener = (FragmentCListener) context;
        }else {
            throw new RuntimeException(context.toString() + " must implement FragmentAListener");
        }
    }
*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c, container, false);

        editText = (EditText) v.findViewById(R.id.fragC);

        return v;
    }
    public void updateEditTextC(CharSequence newText) {
        editText.setText(newText);
    }
}
