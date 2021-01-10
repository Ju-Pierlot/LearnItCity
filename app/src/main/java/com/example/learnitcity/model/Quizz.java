package com.example.learnitcity.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName="Quizz", foreignKeys = @ForeignKey(entity = Article.class,
                    parentColumns = "articleID",
                    childColumns = "fk_articleID",
                    onDelete = ForeignKey.CASCADE))
public class Quizz {

    @PrimaryKey(autoGenerate = true)
    private long ID;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name ="theme")
    private String theme;


    private long fk_articleID;

    public Quizz(String theme, long fk_articleID){
        this.fk_articleID = fk_articleID;
        this.theme = theme;
    }


    public String getTheme(){
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    public long getID(){
        return this.ID;
    }
    public void setID(long id ){this.ID = id;}

    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public long getFk_articleID(){return this.fk_articleID;}
    public void setFk_articleID(long articleID){this.fk_articleID = articleID;}

}
