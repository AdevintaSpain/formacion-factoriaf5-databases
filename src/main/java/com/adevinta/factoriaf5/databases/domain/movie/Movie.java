package com.adevinta.factoriaf5.databases.domain.movie;

import com.adevinta.factoriaf5.databases.domain.platform.Platform;
import java.util.List;

public class Movie {

  private final String id;
  private final String title;
  private final String synopsis;
  private final Integer releaseYear;
  private final List<Featurette> featurettes;
  private final List<Platform> platforms;

  public Movie(String id, String title, String synopsis, Integer releaseYear, List<Featurette> featurettes, List<Platform> platforms) {
    this.id = id;
    this.title = title;
    this.synopsis = synopsis;
    this.releaseYear = releaseYear;
    this.featurettes = featurettes;
    this.platforms = platforms;
  }

  public String getId() {
    return id;
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

  public List<Platform> getPlatforms() {
    return platforms;
  }
}
