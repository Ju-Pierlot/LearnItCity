package com.example.learnitcity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnitcity.R;

import java.util.ArrayList;
import java.util.List;

public class WinningView extends AppCompatActivity {


    private ImageView cup;
    private TextView score;
    private Button goToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_view);

        cup = findViewById(R.id.imageWin);
        score = findViewById(R.id.scoreWin);
        goToMenu = findViewById(R.id.winGoToMenu);

        final Intent intent = getIntent();
        int scoreWin = intent.getIntExtra("score",-1);
        int nbQuestions = intent.getIntExtra("nbQuestions",-1);


        score.setText(String.format("Vos points %d/%d !",scoreWin,nbQuestions));

        goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> rewards = getIntent().getStringArrayListExtra("listeReward");
                Intent intent1 = new Intent(getApplicationContext(), HomeView.class);
                intent1.putStringArrayListExtra("listeReward", (ArrayList<String>) rewards);
                startActivity(intent1);
            }
        });
    }
}
