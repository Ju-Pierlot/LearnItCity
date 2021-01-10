package com.example.learnitcity.model;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "personnage")
public class Personnage {
    @PrimaryKey(autoGenerate = true)
    private long ID;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "nombre", defaultValue = "0")
    private int nombre;

    @Ignore
    private int image;

    public Personnage(String name, int nombre){
        this.name = name;
        this.nombre = nombre;
    }

    public int getNombre(){return this.nombre;}
    public long getID(){return this.ID;}
    public int getImage(){
        return this.image;
    }
    public String getName(){return this.name;}

    public void setID(long Id){this.ID = ID;}
    public void setName(String name){this.name = name;}
    public void setNombre(int nombre){this.nombre = nombre;}
    public void addPlus(int nombre){
        this.nombre += nombre;
    }
    public void setImage(int image){
        this.image = image;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    @Override
    public boolean equals(@Nullable Object obj) {
        return this.name.equals(((Personnage)obj).getName());
    }
}
