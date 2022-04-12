package com.adevinta.factoriaf5.databases.domain.movie;

public class Featurette {

  private final String name;
  private final String url;

  public Featurette(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  public String getName() {
    return name;
  }
}
