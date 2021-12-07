package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ListRepo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repo);
        Intent intent = getIntent();

            ArrayList<Repo> repo = (ArrayList<Repo>) getIntent().getExtras().getSerializable("log");

            RecyclerView listrepo = (RecyclerView) findViewById(R.id.listrepo);
            Adapter adapter = new Adapter(repo);
            listrepo.setAdapter(adapter);
            listrepo.setLayoutManager(new LinearLayoutManager(this));

    }
}