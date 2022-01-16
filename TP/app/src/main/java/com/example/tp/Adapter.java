package com.example.tp;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;


//Création de l'adapteur pour l'affichage des films
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private final List<Movie> mmovie;

    public Adapter( List<Movie> movie) {
        mmovie = movie;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View filmView = inflater.inflate(R.layout.film, parent,false);

        return new ViewHolder(filmView);
    }

    //Configuration de l'image à afficher, du titre à mettre et de la fonction du bouton détail
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = mmovie.get(position);
        ImageView image = holder.Filmaff;
        Button detail = holder.detail;
        TextView titlefilm = holder.titlefilm;
        String load = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
        Glide.with(image.getContext()).load(load).into(image);
        titlefilm.setText(movie.getTitle());
        //On prend l'id du film et on le donne à la page détail lors du click du bouton
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailsMovie.class);
                intent.putExtra("id",movie.getId());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mmovie.size();
    }

    //Image des films et son titre avec deux bouton un pour mettre dans les favoris et l'autre pour afficher les détails
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView Filmaff;
        public Button detail;
        public TextView titlefilm;
        public ViewHolder(View itemView) {
            super(itemView);
            Filmaff = (ImageView) itemView.findViewById((R.id.image));
            detail = (Button) itemView.findViewById((R.id.detail));
            titlefilm = (TextView)  itemView.findViewById(R.id.titlefilm);

        }


    }


}
