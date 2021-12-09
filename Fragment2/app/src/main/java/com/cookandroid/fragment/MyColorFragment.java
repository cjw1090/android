package com.cookandroid.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyColorFragment extends Fragment {
    private  String color;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("프래그먼트예제", "MyColorFragment : onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        if (data != null){
            color = data.getString("ColorSelected");
        } else {
            color = "none";
        }
        Log.i("프래그먼트예제", "MyColorFragment : onCreate"+ color);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("프래그먼트예제", "MyColorFragment : onCreateView"+color);
        return inflater.inflate(R.layout.color_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        switch (color) {
            case "red" :
                getView().setBackgroundColor(Color.RED);
                break;
            case "green":
                getView().setBackgroundColor(Color.GREEN);
                break;
            case "blue" :
                getView().setBackgroundColor(Color.BLUE);
                break;
            default :
                break;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("프래그먼트예제", "MyColorFragment : onActivityCreated"+color);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("프래그먼트예제", "MyColorFragment : onStart"+color);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("프래그먼트예제", "MyColorFragment : onResume"+color);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("프래그먼트예제", "MyColorFragment : onPause"+color);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("프래그먼트예제", "MyColorFragment : onStop"+color);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("프래그먼트예제", "MyColorFragment : onDestroyView"+color);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("프래그먼트예제", "MyColorFragment : onDestroy"+color);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("프래그먼트예제", "MyColorFragment :onDetach"+color);
    }
}
