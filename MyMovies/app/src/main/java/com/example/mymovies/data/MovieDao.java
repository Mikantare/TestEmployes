package com.example.mymovies.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movies")
    LiveData<List<Movie>> getAllMovies();

    @Query("SELECT * FROM favourite_movies")
    LiveData<List<FavouriteMovie>> getAllFavouriteMovies();

    @Query("SELECT * FROM movies WHERE id == :movieId")
    Movie getMovieFromId(int movieId);

    @Query("SELECT * FROM favourite_movies WHERE id == :movieId")
    FavouriteMovie getFavouriteMovieFromId(int movieId);

    @Query("DELETE FROM movies")
    void deleteAllMovie();

    @Query("DELETE FROM favourite_movies")
    void deleteAllFavouriteMovie();

    @Insert
    void insertFavouriteMovie(FavouriteMovie movie);

    @Insert
    void insertMovie(Movie movie);

    @Delete
    void deleteFAvouriteMovie (FavouriteMovie movie);

    @Delete
    void deleteMovie(Movie movie);


}