package com.example.learnitcity.datasource;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.learnitcity.model.Question;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert()
    long insert(Question q);

    @Delete()
    void deleteQuestion(Question q);

    @Query("SELECT * FROM QUESTION WHERE quizzID=:id")
    List<Question> getQuestionsFromQuizz(long id);

    @Query("DELETE  FROM QUESTION")
    void deleteAll();

    @Query("SELECT * FROM QUESTION")
    List<Question> getAll();
}
