package com.example.learnitcity.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.learnitcity.R;
import com.example.learnitcity.presenter.ILaunchPresenter;
import com.example.learnitcity.presenter.LaunchPresenter;

public class Launch extends AppCompatActivity implements ILaunchView{

    private Animation top;
    private ILaunchPresenter launchPresenter;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        //INIT VIEW
        top = AnimationUtils.loadAnimation(this, R.anim.top);

        logo = findViewById(R.id.logo);
        logo.setAnimation(top);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.INTERNET},
                    1);

        }else {
            //INIT
            this.launchPresenter = new LaunchPresenter(this,this);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Launch.this, HomeView.class);
                    startActivity(intent);
                    ActivityCompat.finishAffinity(Launch.this);
                }
            }, 2000);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Launch.this, HomeView.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000);
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
