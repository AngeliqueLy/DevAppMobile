package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        setTitle(getLocalClassName());
        setContentView(R.layout.activity_upcoming_movie);
        MoviesService moviesService = new Retrofit.Builder()
                .baseUrl( MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create( MoviesService.class);

        moviesService.getUpcomingMovies().enqueue(new Callback<MovieResponse>() {
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
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.listfilm2);

        Adapter adapter = new Adapter(movie);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new GridLayoutManager(this,2));


    }


}