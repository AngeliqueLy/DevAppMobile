package com.example.tp;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = mmovie.get(position);
        ImageView image = holder.Filmaff;
        Button detail = holder.detail;

        String load = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
        Glide.with(image.getContext()).load(load).into(image);

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

    void filter(String text){
        List<Movie> temp = new ArrayList();
        List<Movie> displayedList = mmovie;
        for(Movie d: displayedList){
            //or use .equal(text) with you want equal match
            //use  for better matches
            if(d.getTitle().toLowerCase().contains(text)){
                temp.add(d);
            }
        }
        //update recyclerview
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mmovie.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView Filmaff;
        public Button detail;
        public ViewHolder(View itemView) {
            super(itemView);
            Filmaff = (ImageView) itemView.findViewById((R.id.image));
            detail = (Button) itemView.findViewById((R.id.detail));

        }


    }


}
