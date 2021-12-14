package com.example.tp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

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
        View contactView = inflater.inflate(R.layout.film, parent,false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = mmovie.get(position);

        ImageView image = holder.Filmaff;
        Glide.with(image.getContext()).load(movie.getPoster_path()).into(image);
    }

    @Override
    public int getItemCount() {
        return mmovie.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView Filmaff;


        public ViewHolder(View itemView) {
            super(itemView);
            Filmaff = (ImageView) itemView.findViewById((R.id.image));

        }

    }
}
