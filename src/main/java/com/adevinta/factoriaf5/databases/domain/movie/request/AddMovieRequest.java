package com.adevinta.factoriaf5.databases.domain.movie.request;

import com.adevinta.factoriaf5.databases.domain.movie.Featurette;
import java.util.List;

public class AddMovieRequest {

  private final String title;
  private final String synopsis;
  private final Integer releaseYear;
  private final List<Featurette> featurettes;
  private final List<String> platformIds;

  public AddMovieRequest(String title, String synopsis, Integer releaseYear, List<Featurette> featurettes, List<String> platformIds) {
    this.title = title;
    this.synopsis = synopsis;
    this.releaseYear = releaseYear;
    this.featurettes = featurettes;
    this.platformIds = platformIds;
  }

  public String getTitle() {
    return title;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public List<Featurette> getFeaturettes() {
    return featurettes;
  }

  public List<String> getPlatformIds() {
    return platformIds;
  }
}
