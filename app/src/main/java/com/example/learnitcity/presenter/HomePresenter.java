package com.example.learnitcity.presenter;

import android.content.Context;

import com.example.learnitcity.adapter.AdapterTheme;
import com.example.learnitcity.database.LearnItCityDB;
import com.example.learnitcity.model.Theme;
import com.example.learnitcity.view.IHomeView;

import java.util.List;

public class HomePresenter implements IHomePresenter {

    private Context context;
    private IHomeView homeView;
    private LearnItCityDB db;


    public HomePresenter(IHomeView homeView, Context context){
        this.homeView = homeView;
        this.context = context;
        db = LearnItCityDB.getDatabase(context);
    }



}
