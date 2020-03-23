package com.example.tmdbclient.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.tmdbclient.model.Movie;
import com.example.tmdbclient.model.MovieDataSourceFactory;
import com.example.tmdbclient.service.MovieDataService;
import com.example.tmdbclient.service.RetrofitInstance;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivityViewModel extends AndroidViewModel {
//    private MovieRepository movieRepository;
//    private LiveData<MovieDataSource> movieDataSourceLiveData;
    private LiveData<PagedList<Movie>> moviesPagedList;
    private Executor executor;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
//        movieRepository = new MovieRepository(application);

        MovieDataService movieDataService = RetrofitInstance.getService();
        MovieDataSourceFactory movieDataSourceFactory = new MovieDataSourceFactory(movieDataService, application);
//        movieDataSourceLiveData = movieDataSourceFactory.getMutableLiveData();

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10) // number of items
                .setPageSize(20) // number of items in page
                .setPrefetchDistance(10) // number of items when screen loads
                .build();

        executor = Executors.newFixedThreadPool(5);

        moviesPagedList = (new LivePagedListBuilder<Long, Movie>(movieDataSourceFactory, config))
                .setFetchExecutor(executor)
                .build();
    }

//    public LiveData<List<Movie>> getAllMovies() {
//        return movieRepository.getMutableLiveData();
//    }

    public LiveData<PagedList<Movie>> getMoviesPagedList() {
        return moviesPagedList;
    }
}
