package com.example.learnitcity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnitcity.R;
import com.example.learnitcity.adapter.PersoStatsAdapter;
import com.example.learnitcity.model.LearnIt;
import com.example.learnitcity.model.Personnage;

import java.util.ArrayList;
import java.util.List;

public class StatsFragment extends Fragment {
    private RecyclerView listePerso;
    private RecyclerView.Adapter adapterPerso;
    private RecyclerView.LayoutManager adapterManager;

    private Activity activity;
    private LearnIt learnIt;

    private TextView mPourcentString;
    private ProgressBar progressBar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        listePerso = view.findViewById(R.id.state4);
        adapterManager = new LinearLayoutManager(activity);
        adapterPerso = new PersoStatsAdapter(this.learnIt.getmPersonnages());
        listePerso.setLayoutManager(adapterManager);
        listePerso.setAdapter(adapterPerso);
        this.mPourcentString = view.findViewById(R.id.stats);
        this.progressBar = view.findViewById(R.id.statsBar);
        new Thread(new Runnable() {
            public void run() {
                int progressStatus = 0;
                int humor = learnIt.getGlobalHumor();
                while (progressStatus < humor) {
                    progressStatus += 1;
                    progressBar.setProgress(progressStatus, true);
                    final int finalProgressStatus = progressStatus;
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mPourcentString.setText(finalProgressStatus + "%");
                        }
                    });
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return view;

    }
    public StatsFragment(Activity activity, LearnIt learnIt){
        this.activity = activity;
        this.learnIt = learnIt;
    }
}
