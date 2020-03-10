package com.example.mymovies.data;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity (tableName = "favourite_movies")
public class FavouriteMovie extends Movie {
    public FavouriteMovie(int unigueId, int id, int voteCount, String title, String originalTitle, String overview, String posterPath, String BigPosterPath, String backdropPath, double voteAverage, String relaseDate) {
        super(unigueId, id, voteCount, title, originalTitle, overview, posterPath, BigPosterPath, backdropPath, voteAverage, relaseDate);
    }

    @Ignore
    public FavouriteMovie(Movie movie) {
        super(movie.getUnigueId(), movie.getId(), movie.getVoteCount(), movie.getTitle(), movie.getOriginalTitle(), movie.getOverview(), movie.getPosterPath(), movie.getBigPosterPath(), movie.getBackdropPath(), movie.getVoteAverage(), movie.getRelaseDate());
    }
}