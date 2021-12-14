package com.example.tp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesService {
    public static final String ENDPOINT = "https://api.themoviedb.org";

    @GET("/3/movie/popular?api_key=8919f38ef1d66caf6f7cab2da6e68251")
    Call<MovieResponse> getPopularMovies();

}
