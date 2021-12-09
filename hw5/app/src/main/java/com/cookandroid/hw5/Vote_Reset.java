package com.cookandroid.hw5;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Vote_Reset extends Fragment {
    EditText edtNameResult, edtNumberResult;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vote_reset, container, false);
        edtNameResult = (EditText) view.findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) view.findViewById(R.id.edtNumberResult);

        ((MainActivity)getActivity()).voteRe(edtNameResult,edtNumberResult);

        return view;
    }
}
