package com.example.learnitcity.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.learnitcity.R;
import com.example.learnitcity.model.Personnage;

import java.util.List;

public class PersoStatsAdapter extends AbstractAdapter<PersoStatsViewHolder> {
    private List<Personnage> mPersonnage;

    public PersoStatsAdapter(List<Personnage> personnages){
        this.mPersonnage = personnages;
    }

    @Override
    public PersoStatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.habitant_stat, parent, false);
        PersoStatsViewHolder viewHolder = new PersoStatsViewHolder(v, this.getListener());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersoStatsViewHolder holder, int position) {
        Personnage personnage = this.mPersonnage.get(position);
        holder.setJob(personnage.getName());
        holder.setImage(personnage.getImage());
        holder.setNumber(personnage.getNombre());
    }
    @Override
    public int getItemCount() {
        return mPersonnage.size();
    }
}
