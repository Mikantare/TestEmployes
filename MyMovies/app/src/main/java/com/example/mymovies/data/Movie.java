package com.example.mymovies.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "movies")
public class Movie {
    @PrimaryKey (autoGenerate = true)
    private int unigueId;
    private int id;
    private int voteCount;
    private String title;
    private String originalTitle;
    private String overview;
    private String posterPath;
    private String BigPosterPath;
    private String backdropPath;
    private double voteAverage;
    private String relaseDate;

    public Movie(int unigueId, int id, int voteCount, String title, String originalTitle, String overview, String posterPath, String BigPosterPath, String backdropPath, double voteAverage, String relaseDate) {
        this.unigueId = unigueId;
        this.id = id;
        this.voteCount = voteCount;
        this.title = title;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
        this.BigPosterPath = BigPosterPath;
        this.backdropPath = backdropPath;
        this.voteAverage = voteAverage;
        this.relaseDate = relaseDate;
    }
        @Ignore
    public Movie(int id, int voteCount, String title, String originalTitle, String overview, String posterPath, String BigPosterPath, String backdropPath, double voteAverage, String relaseDate) {
        this.id = id;
        this.voteCount = voteCount;
        this.title = title;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
        this.BigPosterPath = BigPosterPath;
        this.backdropPath = backdropPath;
        this.voteAverage = voteAverage;
        this.relaseDate = relaseDate;
    }

    public int getUnigueId() {
        return unigueId;
    }

    public void setUnigueId(int unigueId) {
        this.unigueId = unigueId;
    }

    public String getBigPosterPath() {
        return BigPosterPath;
    }

    public void setBigPosterPath(String bigPosterPath) {
        BigPosterPath = bigPosterPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(String relaseDate) {
        this.relaseDate = relaseDate;
    }
}
