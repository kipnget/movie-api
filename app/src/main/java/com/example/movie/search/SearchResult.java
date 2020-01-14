package com.example.movie.search;
import com.example.movie.model.Movie;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult {

    private Object previous;
    @SerializedName("movie")
    @Expose
    private List<Movie> movie =null;



    public List<Movie> getMovie(){
        return movie;
    }
    public void setMovie(List<Movie> movie){
        this.movie=movie;
    }
}
