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

public class FragmentB extends Fragment {
    private EditText editText;
    private Button buttonOk;
    private FragmentBListener listener=null;  //main Activity

    public interface FragmentBListener {
        void onInputBSent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) { //context = mainactivity
        super.onAttach(context);
        if (context instanceof FragmentBListener) { //메인에 구현되어 있는지 확인
            listener = (FragmentBListener) context;
        }else {
            throw new RuntimeException(context.toString() + " must implement FragmentBListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        editText = (EditText) v.findViewById(R.id.edit_text_b);
        buttonOk = (Button) v.findViewById(R.id.button_ok_b);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editText.getText();
                listener.onInputBSent(input);
            }
        });
        return v;
    }
    public void updateEditTextB(CharSequence newText) {
        editText.setText(newText);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
