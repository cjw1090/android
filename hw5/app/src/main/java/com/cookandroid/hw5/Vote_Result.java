package com.cookandroid.hw5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Vote_Result extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vote_result, container, false);
        TextView tv[] = new TextView[10];
        RatingBar rbar[] = new RatingBar[10];
        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9, R.id.tv10};
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9, R.id.rbar10};
        for(int i=0; i<10; i++){
            tv[i] = (TextView) view.findViewById(tvID[i]);
            rbar[i] = (RatingBar) view.findViewById(rbarID[i]);
        }

        ((MainActivity)getActivity()).voteRes(tv, rbar);


        return view;
    }
}
