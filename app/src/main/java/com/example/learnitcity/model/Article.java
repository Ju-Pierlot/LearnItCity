package com.example.learnitcity.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Article")
public class Article {

    @PrimaryKey(autoGenerate = true)
    public long articleID;

    @ColumnInfo(name="titre")
    private String titre;

    @ColumnInfo(name="contenu")
    private String contenu;

    @ColumnInfo(name="imagePath")
    private String imagePath;

    @ColumnInfo(name="theme")
    private String theme;

    @ColumnInfo(name="status")
    private String status;

    public Article(String titre, String contenu,String imagePath,String theme) {
        this.titre = titre;
        this.contenu = contenu;
        this.imagePath= imagePath;
        this.theme = theme;
        this.status = Status.UNDONE;

    }

    public long getID(){
        return this.articleID;
    }

    public void setID(long id){
        this.articleID = articleID;
    }

    public String getTheme(){
        return this.theme;
    }


    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }
    public String getImagePath(){
        return this.imagePath;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getTitre(){return this.titre;};

    public String getContenu(){return this.contenu;};

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
