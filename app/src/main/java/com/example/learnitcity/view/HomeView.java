package com.example.learnitcity.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.learnitcity.R;
import com.example.learnitcity.adapter.AdapterTheme;
import com.example.learnitcity.database.LearnItCityDB;
import com.example.learnitcity.datasource.PersonnageDao;
import com.example.learnitcity.fragment.CityFragment;
import com.example.learnitcity.fragment.QuizFragment;
import com.example.learnitcity.fragment.StatsFragment;
import com.example.learnitcity.model.LearnIt;
import com.example.learnitcity.model.Logic;
import com.example.learnitcity.model.Personnage;
import com.example.learnitcity.model.Reward;
import com.example.learnitcity.model.Theme;
import com.example.learnitcity.model.city2d.GameSurface;
import com.example.learnitcity.model.city2d.GameThread;
import com.example.learnitcity.presenter.HomePresenter;
import com.example.learnitcity.presenter.IHomePresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeView extends AppCompatActivity implements IHomeView{

    private IHomePresenter presenter;
    private LearnIt learnIt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        presenter = new HomePresenter(this,this);

        init();
        if(getIntent().hasExtra("listeReward")){
            List<String> rewards = getIntent().getStringArrayListExtra("listeReward");
            for (String reward: rewards) {
                String[] re = reward.split("-");
                learnIt.addPerso(new Personnage(re[0], Integer.parseInt(re[1])));
            }

        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new QuizFragment(HomeView.this)).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_quiz:
                            selectedFragment = new QuizFragment(HomeView.this);
                            break;
                        case R.id.nav_people:
                            selectedFragment = new CityFragment(HomeView.this, learnIt);
                            break;
                        case R.id.nav_stats:
                            selectedFragment = new StatsFragment(HomeView.this, learnIt);
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
                private Thread getThreadByName(String threadName) {
                    for (Thread t : Thread.getAllStackTraces().keySet()) {
                        if (t.getName().equals(threadName)) return t;
                    }
                    return null;
                }
    };
    private void init(){
        List <Personnage> persoList;
        LearnItCityDB db = LearnItCityDB.getDatabase(this);
        PersonnageDao persoDao = db.personnageDao();
        persoList = persoDao.selectPersonnage();

        if(persoList.size() == 0){
            Personnage perso1 = new Personnage("Citoyens", 0);
            perso1.setImage(R.drawable.prof);
            persoList.add(perso1);
            Personnage perso2 = new Personnage("Economistes", 0);
            perso2.setImage(R.drawable.econome);
            persoList.add(perso2);
            Personnage perso3 = new Personnage("Fermiers", 0);
            perso3.setImage(R.drawable.fermier);
            persoList.add(perso3);
            Personnage perso4 = new Personnage("Informaticiens", 0);
            perso4.setImage(R.drawable.info);
            persoList.add(perso4);
            Personnage perso5 = new Personnage("Medecins", 0);
            perso5.setImage(R.drawable.medecin);
            persoList.add(perso5);
            for(int i = 0; i < persoList.size(); i++){
                persoDao.insert(persoList.get(i));
            }
        } else {
            for(int i = 0; i < persoList.size(); i++){
                if(persoList.get(i).getName().equals("Citoyens")){
                    persoList.get(i).setImage(R.drawable.prof);
                }
                if(persoList.get(i).getName().equals("Economistes")){
                    persoList.get(i).setImage(R.drawable.econome);
                }
                if(persoList.get(i).getName().equals("Fermiers")){
                    persoList.get(i).setImage(R.drawable.fermier);
                }
                if(persoList.get(i).getName().equals("Informaticiens")){
                    persoList.get(i).setImage(R.drawable.info);
                }
                if(persoList.get(i).getName().equals("Medecins")){
                    persoList.get(i).setImage(R.drawable.medecin);
                }
            }
        }

        this.learnIt = new LearnIt(persoList, new Logic(), persoDao);
    }
}
