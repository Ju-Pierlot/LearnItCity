package com.example.learnitcity.presenter;


import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.learnitcity.database.LearnItCityDB;
import com.example.learnitcity.datasource.ArticleDao;
import com.example.learnitcity.model.Article;
import com.example.learnitcity.view.IListeArticleView;

import java.util.List;

public class ListeArticlePresenter implements IListeArticlePresenter {


    private Context context;
    private IListeArticleView view;
    private LearnItCityDB db;
    private ArticleDao articleDao;

    public ListeArticlePresenter(Context context, IListeArticleView view){
        this.context = context;
        this.view = view;
        this.db = LearnItCityDB.getDatabase(context);
        this.articleDao = db.articleDao();
    }


    @Override
    public void loadAllQuizzForTheme(String theme, RecyclerView.Adapter adapterArticle,List<Article> listArticle) {
        List<Article> articles = articleDao.selectAllArticleByTheme(theme);
        listArticle.clear();
        listArticle.addAll(articles);
        adapterArticle.notifyDataSetChanged();
    }
}


