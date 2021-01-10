package com.example.learnitcity.datasource;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.learnitcity.model.Reponse;

import java.util.List;

@Dao
public interface ReponseDao {
    @Query("SELECT intitule FROM reponse WHERE questionID =:ID")
    List<String> getAnswerFromQuestion(long ID);

    @Query("SELECT intitule FROM reponse WHERE questionID=:ID AND isAnswer == 1")
    String getRightAnswerFormQuesiton(long ID);

    @Insert()
    long insert(Reponse reponse);

    @Delete()
    void delete(Reponse reponse);

    @Query("DELETE  FROM REPONSE")
    void deleteAll();

    @Query("SELECT * FROM REPONSE WHERE questionID=:ID")
    List<Reponse> selectAllByID(long ID);

    @Query("SELECT intitule FROM REPONSE WHERE questionID=:ID AND isAnswer")
    String getReponseFromQuestionByID(long ID);

    @Query("SELECT * FROM reponse")
    List<Reponse> selectAll();
}
