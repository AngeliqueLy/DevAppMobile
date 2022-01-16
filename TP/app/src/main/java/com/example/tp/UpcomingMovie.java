package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpcomingMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.title_activity_upcoming_movie));
        setContentView(R.layout.activity_upcoming_movie);

        //Appel API
        MoviesService moviesService = new Retrofit.Builder()
                .baseUrl( MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create( MoviesService.class);
        ListApp app = (ListApp) getApplicationContext();
        moviesService.getUpcomingMovies(app.getLangueselectionner()).enqueue(new Callback<MovieResponse>() {
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

    //Création menu pour naviguer entre les pages
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intentpop= new Intent(UpcomingMovie.this, PopularMovie.class);
        Intent intentsear = new Intent(UpcomingMovie.this, Search.class);
        switch (item.getItemId()) {

            case R.id.popular:
                startActivity(intentpop);
                finish();

                return true;
            case R.id.favorite:
                return true;
            case R.id.upcoming:

                return true;
            case R.id.research:
                startActivity(intentsear);
                finish();

                return true;
        }
        return false;
    }

    //Fonction qui permet d'afficher les films à venir
    public void afficherMovie(List<Movie> movie) {
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.listfilm2);

        Adapter adapter = new Adapter(movie);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new GridLayoutManager(this,2));


    }


}