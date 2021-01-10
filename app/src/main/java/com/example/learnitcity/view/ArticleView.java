package com.example.learnitcity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learnitcity.R;
import com.example.learnitcity.database.LearnItCityDB;
import com.example.learnitcity.datasource.ArticleDao;
import com.example.learnitcity.model.Article;
import com.example.learnitcity.presenter.IQuestionnairePresenter;
import com.example.learnitcity.presenter.QuestionnairePresenter;

public class ArticleView extends AppCompatActivity implements IArticleView {


    private TextView titre;
    private TextView contenu;
    private Button goToQuestionnaire;
    private IQuestionnairePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        titre = findViewById(R.id.titreA);
        contenu = findViewById(R.id.contenuA);
        goToQuestionnaire = findViewById(R.id.goToQuestionnaire);

        presenter = new QuestionnairePresenter(this,this);
        final Intent intent = getIntent();

        titre.setText(intent.getStringExtra("titre"));
        contenu.setText(intent.getStringExtra("contenu"));

        goToQuestionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LearnItCityDB db = LearnItCityDB.getDatabase(getApplicationContext());
                ArticleDao articleDao = db.articleDao();
                long id = articleDao.getIdByArticleName(intent.getStringExtra("titre"));
                Intent intent1 = new Intent(getApplicationContext(),QuizzView.class);
                intent1.putExtra("articleID", id);
                startActivity(intent1);
            }
        });


    }
}
