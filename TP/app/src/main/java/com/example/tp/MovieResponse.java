package com.example.tp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("results")
    private List<Movie> items;

    public List<Movie> getitem(){
        return items;
    }
}