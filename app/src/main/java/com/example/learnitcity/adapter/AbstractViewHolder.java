package com.example.learnitcity.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class AbstractViewHolder extends RecyclerView.ViewHolder{
    public AbstractViewHolder(View itemView, final OnItemClickListener listener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}
