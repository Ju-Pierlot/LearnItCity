package com.example.learnitcity.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Reward", foreignKeys = @ForeignKey(entity = Article.class,
        parentColumns = "articleID",
        childColumns = "fk_articleId",
        onDelete = ForeignKey.CASCADE))
public class Reward {

    @PrimaryKey(autoGenerate = true)
    private long rewardID;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name="quantite")
    private int quantite;


    private long fk_articleId;

    public Reward(String type, int quantite, long fk_articleId) {
        this.type = type;
        this.quantite = quantite;
        this.fk_articleId = fk_articleId;
    }

    public long getRewardID(){return this.rewardID;}
    public void setRewardID(long rewardID){this.rewardID = rewardID;}
    public long getFk_articleId(){return this.fk_articleId;}
    public void setFk_articleId(long articleId){this.fk_articleId = articleId;}

    public String getType(){
        return this.type;
    }
    public void setType(String typeCharacter) {
        this.type = typeCharacter;
    }

    public int getQuantite(){
        return this.quantite;
    }

    public void setQuantite(int quantite){
        this.quantite = quantite;
    }


}
