package com.example.movie;

import android.content.Context;

import com.example.movie.data.MovieDatabase;
import com.example.movie.data.MovieRepository;
import com.example.movie.ui.info.InfoViewModelFactory;
import com.example.movie.ui.main.FavViewModelFactory;
import com.example.movie.ui.main.MainViewModelFactory;
import com.example.movie.ui.review.ReviewViewModelFactory;
import com.example.movie.ui.trailer.TrailerViewModelFactory;
import com.example.movie.utilities.Controller;
import com.example.movie.utilities.TheMovieApi;

/**
 * Provides static methods to inject the various classes needed for PopularMovies
 */
public class InjectorUtils {

    public static MovieRepository provideRepository(Context context) {
        MovieDatabase database = MovieDatabase.getInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();
        // The Retrofit class generates an implementation of the TheMovieApi interface
        TheMovieApi theMovieApi = Controller.getClient().create(TheMovieApi.class);
        return MovieRepository.getInstance(database.movieDao(), theMovieApi, executors);
    }

    public static MainViewModelFactory provideMainActivityViewModelFactory(Context context, String sortCriteria) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new MainViewModelFactory(repository, sortCriteria);
    }

    public static InfoViewModelFactory provideInfoViewModelFactory(Context context, int movieId) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new InfoViewModelFactory(repository, movieId);
    }

    public static ReviewViewModelFactory provideReviewViewModelFactory(Context context, int movieId) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new ReviewViewModelFactory(repository, movieId);
    }

    public static TrailerViewModelFactory provideTrailerViewModelFactory(Context context, int movieId) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new TrailerViewModelFactory(repository, movieId);
    }

    public static FavViewModelFactory provideFavViewModelFactory(Context context, int movieId) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new FavViewModelFactory(repository, movieId);
    }
}
