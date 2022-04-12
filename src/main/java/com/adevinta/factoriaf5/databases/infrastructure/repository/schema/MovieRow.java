package com.adevinta.factoriaf5.databases.infrastructure.repository.schema;

import java.util.UUID;

public class MovieRow {

  private String id = UUID.randomUUID().toString();
  private String title;
  private String synopsis;
  private Integer releaseYear;

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
}
