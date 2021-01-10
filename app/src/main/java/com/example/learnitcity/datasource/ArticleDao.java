package com.example.learnitcity.datasource;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.learnitcity.model.Article;

import java.util.List;


@Dao
public interface ArticleDao {

    @Insert
    long insert(Article article);

    @Delete()
    void deleteArticle(Article a);

    @Query("DELETE  FROM ARTICLE")
    void deleteAll();

    @Query("SELECT * FROM ARTICLE WHERE theme=:th")
    List<Article> selectAllArticleByTheme(String th);

    @Query("SELECT articleID FROM ARTICLE WHERE titre=:name")
    long getIdByArticleName(String name);

    @Query("UPDATE article SET status=:s WHERE articleID=:id")
    void updatePartyEndDate(long id,String s);

    @Query("SELECT * FROM ARTICLE")
    List<Article> selectAll();
}
