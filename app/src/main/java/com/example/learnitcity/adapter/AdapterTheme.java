package com.example.learnitcity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnitcity.R;
import com.example.learnitcity.model.Theme;
import com.example.learnitcity.view.ListeArticleView;


import java.util.List;

public class AdapterTheme  extends RecyclerView.Adapter<ThemeViewHolder> {

    private Context context;
    private List<Theme> themes;

    public AdapterTheme(Context context, List<Theme> themes) {
        this.context = context;
        this.themes = themes;
    }

    @NonNull
    @Override
    public ThemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.one_theme,parent,false);
        return new ThemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ThemeViewHolder holder, final int position) {
        holder.setImage(themes.get(position).getImage());
        holder.setName(themes.get(position).getNom());
        holder.getLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListeArticleView.class);
                intent.putExtra("theme",themes.get(position).getNom());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return themes.size();
    }
}
