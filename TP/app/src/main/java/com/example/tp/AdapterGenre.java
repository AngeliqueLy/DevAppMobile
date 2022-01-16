package com.example.tp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//Création d'un adapter pour l'affichage des genres
public class AdapterGenre extends RecyclerView.Adapter<AdapterGenre.ViewHolder>{

    private final List<Genre> ggenre;

    public AdapterGenre(List<Genre> genre) {
        ggenre = genre;
    }

    @NonNull
    @Override
    public AdapterGenre.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View genreView = inflater.inflate(R.layout.genre, parent,false);

        return new AdapterGenre.ViewHolder(genreView);
    }

    //Configuration des genres à afficher
    @Override
    public void onBindViewHolder(@NonNull AdapterGenre.ViewHolder holder, int position) {
       Genre genre= ggenre.get(position);
       TextView affichergenre = holder.affgenre;
       affichergenre.setText(genre.getName());
    }

    @Override
    public int getItemCount() {
        return ggenre.size();
    }

    //Affichage des genres
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView affgenre;
        public ViewHolder(View itemView) {
            super(itemView);
            affgenre = (TextView) itemView.findViewById((R.id.genreview));


        }
        }


    }



