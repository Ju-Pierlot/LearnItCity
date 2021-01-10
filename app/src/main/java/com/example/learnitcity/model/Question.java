package com.example.learnitcity.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "question", foreignKeys = @ForeignKey(entity = Quizz.class,
        parentColumns = "ID",
        childColumns = "quizzID",
        onDelete = ForeignKey.CASCADE))
public class Question {
    @PrimaryKey(autoGenerate = true)
    private long ID;

    @ColumnInfo(name = "intitule")
    private String intitule;

    private long quizzID;

    public Question(String intitule, long quizzID){
        this.intitule = intitule;
        this.quizzID = quizzID;
    }
    public String getIntitule(){return this.intitule;}
    public long getID(){return this.ID;}
    public long getQuizzID(){return this.quizzID;}

    public void setID(long ID){this.ID = ID;}
    public void setIntitule(String intitule){this.intitule = intitule;}
    public void setQuizzID(long quizzID){this.quizzID = quizzID;}

}
