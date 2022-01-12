package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getLocalClassName());
        MoviesService moviesService = new Retrofit.Builder()
                .baseUrl(MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesService.class);

        moviesService.getPopularMovies().enqueue(new Callback<MovieResponse>() {
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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);

       return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intentupc = new Intent(MainActivity.this, UpcomingMovie.class);
        Intent intentsear = new Intent(MainActivity.this, Search.class);
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
        }
        return false;
    }

    public void afficherMovie(List<Movie> movie) {

        RecyclerView rvfilm = (RecyclerView) findViewById(R.id.listfilm1);
        Button detail = (Button) findViewById(R.id.detail);
        Adapter adapter = new Adapter(movie);
        rvfilm.setAdapter(adapter);
        rvfilm.setLayoutManager(new GridLayoutManager(this, 2));

    }


}


