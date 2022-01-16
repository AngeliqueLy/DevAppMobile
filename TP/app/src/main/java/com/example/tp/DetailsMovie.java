package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Arrays;


public class DetailsMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);
        setTitle(getResources().getString(R.string.title_activity_details_movie));

        //On récupère l'id du film
        Intent intent = getIntent();
       String id = intent.getStringExtra("id");

       //Appel API pour afficher les détails du films
  MoviesService moviesService = new Retrofit.Builder()
                .baseUrl( MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create( MoviesService.class);

        ListApp app = (ListApp) getApplicationContext();
        moviesService.getDetailMovies(id,app.getLangueselectionner()).enqueue(new Callback<Movie>() {
        @Override
        public void onResponse(Call<Movie> call, Response<Movie> response) {
            afficherDetail(response.body());

        }

        @Override

        public void onFailure(Call<Movie> call, Throwable t) {
            t.getCause();
        }

    });

        //Bouton pour quitter la page détail
        Button quitter = (Button) findViewById((R.id.quitter));
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
//Création du menu pour naviguer entre les pages
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intentupc = new Intent(DetailsMovie.this, UpcomingMovie.class);
        Intent intentsear = new Intent(DetailsMovie.this, Search.class);
        Intent intentlangue = new Intent(DetailsMovie.this, Langue.class);
        Intent intentpop = new Intent(DetailsMovie.this, PopularMovie.class);
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

    //Fonction qui permet d'afficher les détails du film
    public void afficherDetail(Movie movie) {

        //Affichage du film
        String load = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
        ImageView image = (ImageView) findViewById((R.id.imagedet));
        Glide.with(image.getContext()).load(load).into(image);
        //Affichage du titre en fonction de la langue
        TextView title = findViewById(R.id.title) ;
        title.setText(getResources().getString(R.string.titlel)+" "+movie.getTitle());
        //Affichage de la date de sortie fonction de la langue
        TextView releasedate = findViewById(R.id.releasedate) ;
        releasedate.setText(getResources().getString(R.string.releasedatel)+" "+movie.getRelease_date());
        //Affichage du synopsis en fonction de la langue
        TextView overview = findViewById(R.id.overview) ;
        overview.setText(getResources().getString(R.string.overviewl)+" "+movie.getOverview());
        //Affichage des genres en fonction de la langue
        RecyclerView rvgenre = (RecyclerView) findViewById(R.id.listgenre);
        AdapterGenre adaptergenre = new AdapterGenre(Arrays.asList(movie.getGenre().clone()));
        rvgenre.setAdapter(adaptergenre);
        rvgenre.setLayoutManager(new LinearLayoutManager(this));

    }

}