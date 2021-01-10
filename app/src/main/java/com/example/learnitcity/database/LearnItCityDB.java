package com.example.learnitcity.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.learnitcity.datasource.ArticleDao;
import com.example.learnitcity.datasource.PersonnageDao;
import com.example.learnitcity.datasource.QuestionDao;
import com.example.learnitcity.datasource.QuizzDao;
import com.example.learnitcity.datasource.ReponseDao;
import com.example.learnitcity.datasource.RewardDao;
import com.example.learnitcity.model.Article;
import com.example.learnitcity.model.Personnage;
import com.example.learnitcity.model.Question;
import com.example.learnitcity.model.Quizz;
import com.example.learnitcity.model.Reponse;
import com.example.learnitcity.model.Reward;
import com.example.learnitcity.model.Theme;

@Database(entities = {Question.class, Quizz.class,Reponse.class, Article.class, Personnage.class, Reward.class}, version = 12)
public abstract class LearnItCityDB extends RoomDatabase {

    public abstract ArticleDao articleDao();
    public abstract PersonnageDao personnageDao();
    public abstract QuestionDao questionDao();
    public abstract QuizzDao quizzDao();
    public abstract ReponseDao reponseDao();
    public abstract RewardDao rewardDao();

    private static LearnItCityDB INSTANCE;

    public static LearnItCityDB getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LearnItCityDB.class, "learnItDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    public static LearnItCityDB getMemoryDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), LearnItCityDB.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance(){INSTANCE = null;}
}
