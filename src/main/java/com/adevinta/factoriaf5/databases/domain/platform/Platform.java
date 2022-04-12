package com.adevinta.factoriaf5.databases.domain.platform;

public class Platform {

  private final String id;
  private final String name;

  public Platform(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
