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
import com.example.learnitcity.datasource.PersonnageDao;
import com.example.learnitcity.datasource.QuestionDao;
import com.example.learnitcity.datasource.QuizzDao;
import com.example.learnitcity.datasource.ReponseDao;
import com.example.learnitcity.datasource.RewardDao;
import com.example.learnitcity.model.Personnage;
import com.example.learnitcity.model.Question;
import com.example.learnitcity.model.Quizz;
import com.example.learnitcity.model.Reponse;
import com.example.learnitcity.model.Reward;
import com.example.learnitcity.model.Status;

import java.util.ArrayList;
import java.util.List;

public class QuizzView extends AppCompatActivity implements IQuizzView {

    private TextView intitule;
    private TextView numeroQuestion;
    private Button reponse1;
    private Button reponse2;
    private Button reponse3;
    private Button reponse4;
    private List<Question> relatedQuestions;
    private int points;
    private int i = 0;
    private LearnItCityDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_view);
        intitule =findViewById(R.id.intituleQuestion);
        numeroQuestion = findViewById(R.id.numeroQuestion);
        reponse1 = findViewById(R.id.reponse1);
        reponse2 = findViewById(R.id.reponse2);
        reponse3 = findViewById(R.id.reponse3);
        reponse4 = findViewById(R.id.reponse4);


        Intent intent = getIntent();
        final long articleID = intent.getLongExtra("articleID",-1);

        db = LearnItCityDB.getDatabase(getApplicationContext());
        QuestionDao questionDao = db.questionDao();
        QuizzDao quizzDao = db.quizzDao();
        long quizzID = quizzDao.selectRelatedQuizzForArticle(articleID);

        relatedQuestions = questionDao.getQuestionsFromQuizz(quizzID);


        new Thread(new Runnable() {
            public void run() {
                while (i < relatedQuestions.size()) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            final Question question = relatedQuestions.get(i);
                            final String titreQuestion = question.getIntitule();
                            ReponseDao reponseDao = db.reponseDao();
                            final ArticleDao articleDao = db.articleDao();
                            final RewardDao rewardDao = db.rewardDao();
                            final PersonnageDao personnageDao = db.personnageDao();
                            final List<Reponse> allReponses = reponseDao.selectAllByID(question.getID());
                            intitule.setText(titreQuestion);
                            numeroQuestion.setText(String.format("Question n°%d/%d",i+1,relatedQuestions.size()));
                            reponse1.setText(allReponses.get(0).getIntitule());
                            reponse2.setText(allReponses.get(1).getIntitule());
                            reponse3.setText(allReponses.get(2).getIntitule());
                            reponse4.setText(allReponses.get(3).getIntitule());

                            reponse1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    checkIfCorrect(question,allReponses.get(0).getIntitule());
                                    if(i+1>= relatedQuestions.size()) {
                                        //TODO
                                        if(isWin(relatedQuestions)) {
                                            //WIN
                                            List<Reward> rewards = rewardDao.selectReward(articleID);
                                            List<String> re = new ArrayList<String>();
                                            for (Reward reward: rewards) {
                                                re.add(reward.getType()+ "-" + reward.getQuantite());
                                            }
                                            Intent intent = new Intent(getApplicationContext(), WinningView.class);
                                            intent.putExtra("score",points);
                                            intent.putStringArrayListExtra("listeReward", (ArrayList<String>) re);
                                            intent.putExtra("nbQuestions",relatedQuestions.size());
                                            articleDao.updatePartyEndDate(articleID, Status.DONE);
                                            startActivity(intent);
                                            i++;
                                            Thread.interrupted();
                                        }else{
                                            //LOOSE
                                            Intent intent = new Intent(getApplicationContext(), LoosingView.class);
                                            intent.putExtra("score",points);
                                            intent.putExtra("nbQuestions",relatedQuestions.size());
                                            startActivity(intent);
                                            i++;
                                            Thread.interrupted();
                                        }
                                    }else{
                                        i++;
                                    }
                                }
                            });
                            reponse2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    checkIfCorrect(question,allReponses.get(1).getIntitule());
                                    if(i+1>= relatedQuestions.size()) {
                                        if(isWin(relatedQuestions)) {
                                            //WIN
                                            List<Reward> rewards = rewardDao.selectReward(articleID);
                                            List<String> re = new ArrayList<String>();
                                            for (Reward reward: rewards) {
                                                re.add(reward.getType()+ "-" + reward.getQuantite());
                                            }
                                            Intent intent = new Intent(getApplicationContext(), WinningView.class);
                                            intent.putExtra("score",points);
                                            intent.putStringArrayListExtra("listeReward", (ArrayList<String>) re);
                                            intent.putExtra("nbQuestions",relatedQuestions.size());
                                            articleDao.updatePartyEndDate(articleID, Status.DONE);
                                            startActivity(intent);
                                        }else{
                                            //LOOSE
                                            Intent intent = new Intent(getApplicationContext(), LoosingView.class);
                                            intent.putExtra("score",points);
                                            intent.putExtra("nbQuestions",relatedQuestions.size());
                                            startActivity(intent);
                                        }
                                        i++;
                                        Thread.interrupted();
                                    }else{
                                        i++;
                                    }
                                }
                            });
                            reponse3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    checkIfCorrect(question,allReponses.get(2).getIntitule());
                                    if(i+1>= relatedQuestions.size()) {
                                        if(isWin(relatedQuestions)) {
                                            //WIN
                                            List<Reward> rewards = rewardDao.selectReward(articleID);
                                            List<String> re = new ArrayList<String>();
                                            for (Reward reward: rewards) {
                                                re.add(reward.getType()+ "-" + reward.getQuantite());
                                            }
                                            Intent intent = new Intent(getApplicationContext(), WinningView.class);
                                            intent.putExtra("score",points);
                                            intent.putStringArrayListExtra("listeReward", (ArrayList<String>) re);
                                            intent.putExtra("nbQuestions",relatedQuestions.size());
                                            articleDao.updatePartyEndDate(articleID, Status.DONE);
                                            startActivity(intent);
                                        }else{
                                            //LOOSE
                                            Intent intent = new Intent(getApplicationContext(), LoosingView.class);
                                            intent.putExtra("score",points);
                                            intent.putExtra("nbQuestions",relatedQuestions.size());
                                            startActivity(intent);
                                        }
                                        i++;
                                        Thread.interrupted();
                                    }else{
                                        i++;
                                    }
                                }
                            });
                            reponse4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    checkIfCorrect(question,allReponses.get(3).getIntitule());
                                    if(i+1>= relatedQuestions.size()) {
                                        if(isWin(relatedQuestions)) {
                                            //WIN
                                            List<Reward> rewards = rewardDao.selectReward(articleID);
                                            List<String> re = new ArrayList<String>();
                                            for (Reward reward: rewards) {
                                                re.add(reward.getType()+ "-" + reward.getQuantite());
                                            }
                                            Intent intent = new Intent(getApplicationContext(), WinningView.class);
                                            intent.putExtra("score",points);
                                            intent.putStringArrayListExtra("listeReward", (ArrayList<String>) re);
                                            intent.putExtra("nbQuestions",relatedQuestions.size());
                                            articleDao.updatePartyEndDate(articleID, Status.DONE);
                                            startActivity(intent);
                                        }else{
                                            //LOOSE
                                            Intent intent = new Intent(getApplicationContext(), LoosingView.class);
                                            intent.putExtra("score",points);
                                            intent.putExtra("nbQuestions",relatedQuestions.size());
                                            startActivity(intent);
                                        }
                                        i++;
                                        Thread.interrupted();
                                    }else{
                                        i++;
                                    }
                                }
                            });
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void checkIfCorrect(Question question,String reponse) {
        String reponseAttendue = db.reponseDao().getReponseFromQuestionByID(question.getID());
        if(reponse.equals(reponseAttendue)) {
            points++;
        }
    }

    private boolean isWin(List<Question> relatedQuestions){
        return points >= (relatedQuestions.size()/2);
    }


}
