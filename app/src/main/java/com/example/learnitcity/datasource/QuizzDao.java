package com.example.learnitcity.datasource;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.learnitcity.model.Question;
import com.example.learnitcity.model.Quizz;

import java.util.List;

@Dao
public interface QuizzDao {


    @Insert
    long insert(Quizz quizz);

    @Delete()
    void delete(Quizz quizz);

    @Query("UPDATE Quizz SET status=:s WHERE ID=:id")
    void updateStatus(String s,long id);

    @Query("SELECT * FROM Quizz WHERE theme=:t")
    List<Quizz> selectAllQuizzByTheme(String t);

    @Query("SELECT ID FROM Quizz WHERE fk_articleID=:aId")
    long selectRelatedQuizzForArticle(long aId);

    @Query("DELETE FROM QUIZZ")
    void deleteAll();

    @Query("SELECT * FROM Quizz")
    List<Quizz> selectAll();
}
