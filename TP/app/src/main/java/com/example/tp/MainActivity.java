package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MoviesService moviesService = new Retrofit.Builder()
                .baseUrl( MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create( MoviesService.class);

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
    public void afficherMovie(List<Movie> movie) {
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.listfilm);

        Adapter adapter = new Adapter(movie);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        Toast.makeText(this,"nombre de film : "+movie.size(), Toast.LENGTH_SHORT).show();

    }


        }


