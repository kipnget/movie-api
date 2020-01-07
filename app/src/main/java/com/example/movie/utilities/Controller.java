package com.example.movie.utilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.movie.utilities.Constant.MOVIE_BASE_URL;

/**
 *  Create a singleton of Retrofit.
 */
public class Controller {

    /** Static variable for Retrofit */
    private static Retrofit sRetrofit = null;

    public static Retrofit getClient() {
        if (sRetrofit == null) {
            // Create the Retrofit instance using the builder
            sRetrofit = new Retrofit.Builder()
                    // Set the API base URL
                    .baseUrl(MOVIE_BASE_URL)
                    // Use GsonConverterFactory class to generate an implementation of the TheMovieApi interface
                    // which uses Gson for its deserialization
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
