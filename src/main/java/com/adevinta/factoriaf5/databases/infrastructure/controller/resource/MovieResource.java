package com.adevinta.factoriaf5.databases.infrastructure.controller.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResource {

  private String id;
  private String title;
  private String synopsis;
  private Integer releaseYear;
  private List<FeaturetteResource> featurettes = new ArrayList<>();
  private List<PlatformResource> platforms = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public List<FeaturetteResource> getFeaturettes() {
    return featurettes;
  }

  public void setFeaturettes(List<FeaturetteResource> featurettes) {
    this.featurettes = featurettes;
  }

  public List<PlatformResource> getPlatforms() {
    return platforms;
  }

  public void setPlatforms(List<PlatformResource> platforms) {
    this.platforms = platforms;
  }
}
