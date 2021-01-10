package com.example.learnitcity.presenter;

import android.content.Context;

import com.example.learnitcity.view.IArticleView;

public class QuestionnairePresenter implements  IQuestionnairePresenter {

    private Context context;
    private IArticleView view;

    public QuestionnairePresenter(Context context, IArticleView view) {
        this.context = context;
        this.view = view;
    }

}
