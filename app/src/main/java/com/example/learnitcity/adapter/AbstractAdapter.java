package com.example.learnitcity.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class AbstractAdapter<vh extends AbstractViewHolder> extends RecyclerView.Adapter<vh>{
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }
    public OnItemClickListener getListener(){
        return this.mListener;
    }

    @Override
    public abstract vh onCreateViewHolder(ViewGroup parent, int viewType);
    @Override
    public abstract void onBindViewHolder(@NonNull vh holder, int position);

}
