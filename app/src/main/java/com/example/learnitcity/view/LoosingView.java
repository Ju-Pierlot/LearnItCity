package com.example.learnitcity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnitcity.R;

public class LoosingView extends AppCompatActivity {

    private ImageView cup;
    private TextView score;
    private Button goToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loosing_view);

        cup = findViewById(R.id.imageLoose);
        score = findViewById(R.id.scoreLoose);
        goToMenu = findViewById(R.id.looseGoToMenu);

        Intent intent = getIntent();
        int scoreWin = intent.getIntExtra("score",-1);
        int nbQuestions = intent.getIntExtra("nbQuestions",-1);


        score.setText(String.format("Vos points %d/%d !",scoreWin,nbQuestions));

        goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), HomeView.class);
                startActivity(intent1);
            }
        });
    }
}
