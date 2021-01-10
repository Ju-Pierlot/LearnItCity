package com.example.learnitcity.model;

import android.graphics.drawable.Drawable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Theme {


    private String nom;

    private Drawable image;

    public Theme(String nom,Drawable image){
        this.nom = nom;
        this.image = image;
    }

    public String getNom(){
        return this.nom;
    }

    public Drawable getImage(){
        return this.image;
    }
}
