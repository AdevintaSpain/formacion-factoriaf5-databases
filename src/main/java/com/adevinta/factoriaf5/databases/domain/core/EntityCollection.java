package com.adevinta.factoriaf5.databases.domain.core;

import java.util.List;

public class EntityCollection<T> {

  private final List<T> collection;

  public EntityCollection(List<T> collection) {
    this.collection = collection;
  }

  public List<T> getCollection() {
    return collection;
  }
}
