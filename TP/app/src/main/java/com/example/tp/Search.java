package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Search extends AppCompatActivity {
    ArrayAdapter<String> arrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        MoviesService moviesService = new Retrofit.Builder()
                .baseUrl(MoviesService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesService.class);

        moviesService.getPopularMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                ArrayList<Movie> movie;
                movie=(ArrayList<Movie>) response.body().getitem();
                RecyclerView rvfilm = (RecyclerView) findViewById(R.id.listfilm1);
                Button detail = (Button) findViewById(R.id.detail);
                Adapter adapter = new Adapter(movie);
                EditText search = findViewById(R.id.search);

                search.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        // filter your list from your input
                        adapter.filter(s.toString());
                        //you can use runnable postDelayed like 500 ms to delay search text
                    }
                });
            }

            @Override

            public void onFailure(Call<MovieResponse> call, Throwable t) {
                t.getCause();
            }

        });
    }



    }
