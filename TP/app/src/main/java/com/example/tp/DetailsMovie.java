package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class DetailsMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);
        Intent intent = getIntent();
       String id = intent.getStringExtra("id");
  MoviesService moviesService = new Retrofit.Builder()
                .baseUrl( MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create( MoviesService.class);


        moviesService.getDetailMovies(id).enqueue(new Callback<Movie>() {
        @Override
        public void onResponse(Call<Movie> call, Response<Movie> response) {
            afficherDetail(response.body());


        }

        @Override

        public void onFailure(Call<Movie> call, Throwable t) {
            t.getCause();
        }

    });
        Button quitter = (Button) findViewById((R.id.quitter));
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
}
    public void afficherDetail(Movie movie) {
        String load = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
        ImageView image = (ImageView) findViewById((R.id.imagedet));
        Glide.with(image.getContext()).load(load).into(image);
        TextView title = findViewById(R.id.title) ;
        title.setText("Title :"+" "+movie.getTitle());
        TextView releasedate = findViewById(R.id.releasedate) ;
        releasedate.setText("Release date:"+" "+movie.getRelease_date());
        TextView overview = findViewById(R.id.overview) ;
        overview.setText("Overview:"+" "+movie.getOverview());

    }

}