package com.cookandroid.exfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    private EditText editText;
    private Button buttonOk;
    private FragmentAListener listener=null;  //main Activity

    public interface FragmentAListener {
        void onInputASent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) { //context = mainactivity
        super.onAttach(context);
        if (context instanceof FragmentAListener) { //메인에 구현되어 있는지 확인
            listener = (FragmentAListener) context;
        }else {
            throw new RuntimeException(context.toString() + " must implement FragmentAListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        editText = (EditText) v.findViewById(R.id.edit_text_a);
        buttonOk = (Button) v.findViewById(R.id.button_ok_a);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
            }
        });
        return v;
    }
    public void updateEditTextA(CharSequence newText) {
        editText.setText(newText);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
