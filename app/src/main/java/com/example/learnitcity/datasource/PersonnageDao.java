package com.example.learnitcity.datasource;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.learnitcity.model.Article;
import com.example.learnitcity.model.Personnage;
import com.example.learnitcity.model.Question;

import java.util.List;

@Dao
public interface PersonnageDao {
    @Query("SELECT name FROM personnage WHERE ID =:ID")
    String getNameOfCharacter(long ID);

    @Query("SELECT * FROM PERSONNAGE")
    List<Personnage> selectPersonnage();

    @Query("DELETE  FROM personnage")
    void deleteAll();

    @Insert()
    long insert(Personnage q);

    @Delete()
    void deleteCharacter(Personnage a);


    @Query("SELECT * FROM personnage")
    List<Personnage> selectAll();

    @Query("UPDATE personnage SET nombre=:num WHERE name=:na")
    void updateNombre(int num, String na);
}
