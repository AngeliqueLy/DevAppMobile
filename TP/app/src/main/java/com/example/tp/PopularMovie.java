package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;


import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PopularMovie extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.title_activity_popular_movie));

        //Appel API
        MoviesService moviesService = new Retrofit.Builder()
                .baseUrl(MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesService.class);
        ListApp app = (ListApp) getApplicationContext();
        moviesService.getPopularMovies(app.getLangueselectionner()).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                afficherMovie(response.body().getitem());

            }

            @Override

            public void onFailure(Call<MovieResponse> call, Throwable t) {
                t.getCause();
            }

        });
    }
//Création du menu pour naviguer entre les pages
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);

       return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intentupc = new Intent(PopularMovie.this, UpcomingMovie.class);
        Intent intentsear = new Intent(PopularMovie.this, Search.class);
        Intent intentlangue = new Intent(PopularMovie.this, Langue.class);
        switch (item.getItemId()) {

            case R.id.popular:
                return true;
            case R.id.favorite:
                return true;
            case R.id.upcoming:
                startActivity(intentupc);
                finish();
                return true;
            case R.id.research:
                startActivity(intentsear);
                finish();
                return true;
            case R.id.langue:
                startActivity(intentlangue);
                finish();
                return true;
        }
        return false;
    }

    //Fonction pour afficher la liste des films populaires
    public void afficherMovie(List<Movie> movie) {

        RecyclerView rvfilm = (RecyclerView) findViewById(R.id.listfilm1);
        Adapter adapter = new Adapter(movie);
        rvfilm.setAdapter(adapter);
        rvfilm.setLayoutManager(new GridLayoutManager(this, 2));



    }



}


