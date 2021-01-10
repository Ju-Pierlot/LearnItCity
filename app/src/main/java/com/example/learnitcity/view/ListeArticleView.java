package com.example.learnitcity.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.learnitcity.R;
import com.example.learnitcity.adapter.ArticleAdapter;
import com.example.learnitcity.model.Article;
import com.example.learnitcity.model.Quizz;
import com.example.learnitcity.presenter.IListeArticlePresenter;
import com.example.learnitcity.presenter.ListeArticlePresenter;

import java.util.ArrayList;
import java.util.List;

public class ListeArticleView extends AppCompatActivity implements IListeArticleView {

    private IListeArticlePresenter presenter;
    private RecyclerView listeQuizz;
    private List<Article> articleList;
    private RecyclerView.Adapter adapterArticle;
    private RecyclerView.LayoutManager adapterManager;

    //private MenuBarView menuBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_article_view);
        listeQuizz = findViewById(R.id.listeArticle);

        articleList = new ArrayList<>();
        String theme = getIntent().getStringExtra("theme");
        adapterArticle = new ArticleAdapter(this,articleList);
        listeQuizz.setAdapter(adapterArticle);

        presenter = new ListeArticlePresenter(this,this);
        presenter.loadAllQuizzForTheme(theme,adapterArticle,articleList);
        adapterManager = new LinearLayoutManager(this);
        listeQuizz.setLayoutManager(adapterManager);




        //this.menuBar = new MenuBarView(this);



    }
}
