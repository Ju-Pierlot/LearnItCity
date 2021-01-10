package com.example.learnitcity.datasource;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.learnitcity.model.Quizz;
import com.example.learnitcity.model.Reward;

import java.util.List;

@Dao
public interface RewardDao {
    @Insert
    long insert(Reward reward);

    @Query("SELECT * FROM Reward WHERE fk_articleId=:id")
    List<Reward> selectReward(long id);

    @Query("DELETE FROM Reward")
    void deleteAll();
}
