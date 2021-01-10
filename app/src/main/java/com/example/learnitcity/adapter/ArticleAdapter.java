package com.example.learnitcity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnitcity.R;
import com.example.learnitcity.database.LearnItCityDB;
import com.example.learnitcity.datasource.RewardDao;
import com.example.learnitcity.model.Article;
import com.example.learnitcity.model.LearnIt;
import com.example.learnitcity.model.Reward;
import com.example.learnitcity.model.Status;
import com.example.learnitcity.view.ArticleView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private List<Article> listArticles;
    private Context context;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.listArticles = articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.one_article,parent,false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        final Article article = listArticles.get(position);
        holder.setStatus(article.getStatus());
        holder.setNom(article.getTitre());
        LearnItCityDB db = LearnItCityDB.getDatabase(context);
        RewardDao rewardD = db.rewardDao();

        List<Reward> rewards = rewardD.selectReward(article.getID());
        String rewar ="";
        for (Reward reward:rewards) {
            rewar += String.format("%dx : %s \n",reward.getQuantite(), reward.getType());
        }
        holder.setRecompenses(rewar);
        holder.setImage(article.getImagePath());
        holder.getLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(article.getStatus().equals(Status.DONE)) {
                    Toast.makeText(context, "Vous avez déjà lu cet article", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(context, ArticleView.class);
                    intent.putExtra("titre",article.getTitre());
                    intent.putExtra("contenu",article.getContenu());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listArticles.size();
    }
}
