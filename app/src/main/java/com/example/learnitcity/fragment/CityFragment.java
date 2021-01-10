package com.example.learnitcity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.learnitcity.R;
import com.example.learnitcity.model.LearnIt;
import com.example.learnitcity.model.city2d.GameSurface;

public class CityFragment extends Fragment {

    private Activity activity;
    private LearnIt learnIt;
    public CityFragment(Activity activity, LearnIt learnIt){
        this.activity = activity;
        this.learnIt = learnIt;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_city, container, false);
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.linearLayout) ;
        SurfaceView city = new GameSurface(activity,learnIt);
        linearLayout.addView(city);
        return view;
    }
}
