package com.cookandroid.myapplication;

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


public class FragmentMain extends Fragment {
    EditText edt1;
    Button frag_a, frag_b, frag_c;
    String input;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mainfragment, container, false);
        edt1 = (EditText) v.findViewById(R.id.edt1);
        frag_a = (Button) v.findViewById(R.id.frag_a);
        frag_b = (Button) v.findViewById(R.id.frag_b);
        frag_c = (Button) v.findViewById(R.id.frag_c);
        frag_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edt1.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Name", input);
                ((MainActivity)getActivity()).FragChange("A", bundle);

            }
        });

        frag_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edt1.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Name", input);
                ((MainActivity)getActivity()).FragChange("B", bundle);

            }
        });

        frag_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edt1.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Name", input);
                ((MainActivity)getActivity()).FragChange("C", bundle);
            }
        });

        return v;
    }


    
}
