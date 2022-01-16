package com.example.tp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesService {
    public static final String ENDPOINT = "https://api.themoviedb.org";

    @GET("/3/movie/popular?api_key=8919f38ef1d66caf6f7cab2da6e68251")
    Call<MovieResponse> getPopularMovies(@Query("language") String langue);

    @GET("/3/movie/upcoming?api_key=8919f38ef1d66caf6f7cab2da6e68251")
    Call<MovieResponse> getUpcomingMovies(@Query("language") String langue);

    @GET("/3/movie/{movie_id}?api_key=8919f38ef1d66caf6f7cab2da6e68251")
    Call<Movie> getDetailMovies(@Path("movie_id") String id,@Query("language") String langue);

    @GET("/3/search/movie?api_key=8919f38ef1d66caf6f7cab2da6e68251")
    Call<MovieResponse>ResearchMovies(@Query("query") String query,@Query("language") String langue);




}
