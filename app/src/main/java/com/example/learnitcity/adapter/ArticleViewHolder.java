package com.example.learnitcity.adapter;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnitcity.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

class ArticleViewHolder extends RecyclerView.ViewHolder {


    private TextView nom;
    private TextView recompense;
    private TextView status;
    private ImageView image;
    private RelativeLayout layout;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nom = itemView.findViewById(R.id.titreArticle);
        this.status = itemView.findViewById(R.id.statusArticle);
        this.recompense = itemView.findViewById(R.id.recompenseArticle);
        this.image = itemView.findViewById(R.id.imageArticle);
        this.layout = itemView.findViewById(R.id.articleLayout);
    }

    public RelativeLayout getLayout(){
        return this.layout;
    }

    public void setRecompenses(String recompense) {
        this.recompense.setText(recompense);
    }

    public void setStatus(String status){
        this.status.setText(status);
    }

    public void setNom(String nom) {
        this.nom.setText(nom);
    }

    public void setImage(String path){
        Picasso.get().load(path).into(image);
    }


}
