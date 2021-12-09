package com.cookandroid.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    EditText edt_frag_a;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        edt_frag_a = (EditText) v.findViewById(R.id.edt_frag_a);
        Bundle bundle = getArguments();
        if(bundle != null){
            String name = bundle.getString("Name");
            System.out.println(name);
            edt_frag_a.setText(name);
        }
        return v;
    }


}
