package com.example.learnitcity.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnitcity.R;

public class PersoStatsViewHolder extends AbstractViewHolder{
    private TextView mJob;
    private TextView mNumber;
    private ImageView mImage;

    public PersoStatsViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView, listener);
        this.mNumber = itemView.findViewById(R.id.nb_perso);
        this.mJob = itemView.findViewById(R.id.job_perso);
        this.mImage = itemView.findViewById(R.id.image_perso);
    }
    public void setJob(String job){
        this.mJob.setText(job);
    }
    public void setNumber(int number){
        this.mNumber.setText(Integer.toString(number));
    }
    public void setImage(int image){
        this.mImage.setImageResource(image);
    }
}
