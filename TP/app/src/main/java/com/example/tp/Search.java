package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Search extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle(getResources().getString(R.string.research));

        //Bouton pour valider la recherche
        Button ok = findViewById(R.id.ok);
        //Saisi de l'utilisateur
        EditText film = findViewById(R.id.search);

        //Appel API pour la recherche des film
        MoviesService moviesService = new Retrofit.Builder()
                .baseUrl(MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesService.class);
        ListApp app = (ListApp) getApplicationContext();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        moviesService.ResearchMovies(film.getText().toString() ,app.getLangueselectionner()).enqueue(new Callback<MovieResponse>() {
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
        });
    }

    //Création du menu pour passer d'une page à une autre
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intentupc = new Intent(Search.this, UpcomingMovie.class);
        Intent intentpop = new Intent(Search.this, PopularMovie.class);
        Intent intentlangue = new Intent(Search.this, Langue.class);
        switch (item.getItemId()) {

            case R.id.popular:
                startActivity(intentpop);
                finish();
                return true;
            case R.id.favorite:
                return true;
            case R.id.upcoming:
                startActivity(intentupc);
                finish();
                return true;
            case R.id.research:

                return true;
            case R.id.langue:
                startActivity(intentlangue);
                finish();
                return true;
        }
        return false;
    }

//Fonction qui affiche le poster des film et son titre quand l'utilisateur entre le nom d'un film
    public void afficherMovie(List<Movie> movie) {
        RecyclerView rvfilm = (RecyclerView) findViewById(R.id.listfilm3);
        Adapter adapter = new Adapter(movie);
        rvfilm.setAdapter(adapter);
        rvfilm.setLayoutManager(new GridLayoutManager(this, 2));


    }

}



