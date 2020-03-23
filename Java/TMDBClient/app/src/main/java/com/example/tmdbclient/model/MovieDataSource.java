package com.example.tmdbclient.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.tmdbclient.R;
import com.example.tmdbclient.service.MovieDataService;
import com.example.tmdbclient.service.RetrofitInstance;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDataSource extends PageKeyedDataSource<Long, Movie> {
    private MovieDataService movieDataService;
    private Application application;

    MovieDataSource(MovieDataService movieDataService, Application application) {
        this.movieDataService = movieDataService;
        this.application = application;
    }

    @Override
    public void loadInitial(@NonNull final LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, Movie> callback) {
        movieDataService = RetrofitInstance.getService();
        Call<MovieDBResponse> call = movieDataService.getPopularMoviesWithPaging(application.getApplicationContext().getString(R.string.api_key), (long) 1);
        call.enqueue(new Callback<MovieDBResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieDBResponse> call, @NotNull Response<MovieDBResponse> response) {
                MovieDBResponse movieDBResponse = response.body();
                if (movieDBResponse != null && movieDBResponse.getMovies() != null) {
                    ArrayList<Movie> movies = (ArrayList<Movie>) movieDBResponse.getMovies();
                    callback.onResult(movies, null, (long) 2);
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieDBResponse> call, @NotNull Throwable t) {
//                No implemented yet
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Movie> callback) {
//        No implemented yet
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, Movie> callback) {
        movieDataService = RetrofitInstance.getService();
        Call<MovieDBResponse> call = movieDataService.getPopularMoviesWithPaging(application.getApplicationContext().getString(R.string.api_key), params.key);
        call.enqueue(new Callback<MovieDBResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieDBResponse> call, @NotNull Response<MovieDBResponse> response) {
                MovieDBResponse movieDBResponse = response.body();
                if (movieDBResponse != null && movieDBResponse.getMovies() != null) {
                    ArrayList<Movie> movies = (ArrayList<Movie>) movieDBResponse.getMovies();
                    callback.onResult(movies, params.key + 1);
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieDBResponse> call, @NotNull Throwable t) {
//                No implemented yet
            }
        });
    }
}
