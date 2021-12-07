package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
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
        setTitle(getLocalClassName());
        Button ok = findViewById(R.id.buttonok);
        EditText user = findViewById(R.id.user);
        GitHubService githubService = new Retrofit.Builder()
                .baseUrl(GitHubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubService.class);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                githubService.listRepos(user.getText().toString()).enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        afficherRepos(response.body());
                    }

                    @Override

                    public void onFailure(Call<List<Repo>> call, Throwable t) {

                    }

                });
            }
        });
    }
    public void afficherRepos(List<Repo> repos) {
        ArrayList<Repo> repobis;
        repobis = (ArrayList<Repo>) repos;
        Intent intent = new Intent(this, ListRepo.class);
        intent.putExtra("log", repobis);
        startActivity(intent);

    }

}

