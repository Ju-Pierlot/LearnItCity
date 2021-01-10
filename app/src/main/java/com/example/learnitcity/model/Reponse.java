package com.example.learnitcity.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "reponse", foreignKeys = @ForeignKey(entity = Question.class,
        parentColumns = "ID",
        childColumns = "questionID",
        onDelete = ForeignKey.CASCADE))
public class Reponse {

    @PrimaryKey(autoGenerate = true)
    private long ID;

    @ColumnInfo(name = "intitule")
    private String intitule;

    @ColumnInfo(name = "isAnswer")
    private boolean isAnswer;

    private long questionID;

    public Reponse(String intitule,boolean isAnswer,long questionID){
        this.intitule = intitule;
        this.isAnswer = isAnswer;
        this.questionID =questionID;
    }
    public long getID(){return this.ID;}
    public void setID(long Id){this.ID = Id;}

    public String getIntitule(){return this.intitule;}
    public void setIntitule(String intitule){this.intitule = intitule;}

    public long getQuestionID(){return this.questionID;}
    public void setQuestionID(long questionID){this.questionID = questionID;}

    public boolean getAnswer(){return this.isAnswer;}
    public void setAnswer(boolean isAnswer){this.isAnswer = isAnswer;}


}
