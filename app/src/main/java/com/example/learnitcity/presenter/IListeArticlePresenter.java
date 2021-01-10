package com.example.learnitcity.presenter;

import androidx.recyclerview.widget.RecyclerView;

import com.example.learnitcity.model.Article;


import java.util.List;

public interface IListeArticlePresenter {


    void loadAllQuizzForTheme(String theme, RecyclerView.Adapter adapterArticle, List<Article> listeArticle);
}
