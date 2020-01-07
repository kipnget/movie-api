package com.example.movie.ui;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.movie.data.MovieRepository;

/**
 * Factory method that allows us to create a ViewModel with a constructor that takes a
 * {@link MovieRepository} and the movie ID
 */
public class FavViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final MovieRepository mRepository;
    private final int mMovieId;

    public FavViewModelFactory(MovieRepository repository, int movieId) {
        mRepository = repository;
        mMovieId = movieId;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new FavViewModel(mRepository, mMovieId);
    }
}
