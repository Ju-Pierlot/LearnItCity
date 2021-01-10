package com.example.learnitcity.presenter;

import android.content.Context;

import com.example.learnitcity.view.ILaunchView;

public class LaunchPresenter implements ILaunchPresenter{

    private Context context;
    private ILaunchView launchView;

    public LaunchPresenter(ILaunchView launchView, Context context){
        this.launchView = launchView;
        this.context = context;
    }
}
