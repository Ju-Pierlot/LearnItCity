package com.example.learnitcity.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnitcity.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ThemeViewHolder  extends RecyclerView.ViewHolder{


    private ImageView image;
    private TextView nom;
    private RelativeLayout layout;

    public ThemeViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageTheme);
        nom = itemView.findViewById(R.id.nomTheme);
        layout = itemView.findViewById(R.id.themeLayout);
    }


    public void setName(String name){
        this.nom.setText(name);
    }

    public void setImage(Drawable drawable){
            image.setImageDrawable(drawable);
            //Picasso.get().load(path).into(image);
    }

    public RelativeLayout getLayout(){
        return this.layout;
    }

}
