package com.adevinta.factoriaf5.databases.infrastructure.repository.schema;

public class MoviePlatformRow {

  private String movieId;
  private String platformId;

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public String getPlatformId() {
    return platformId;
  }

  public void setPlatformId(String platformId) {
    this.platformId = platformId;
  }
}
