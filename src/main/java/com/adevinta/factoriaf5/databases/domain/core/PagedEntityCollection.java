package com.adevinta.factoriaf5.databases.domain.core;

import java.util.List;

public class PagedEntityCollection<T> extends EntityCollection<T> {

  private final Page page;
  private final Integer totalCount;

  public PagedEntityCollection(Page page, Integer totalCount, List<T> collection) {
    super(collection);
    this.page = page;
    this.totalCount = totalCount;
  }

  public Page getPage() {
    return page;
  }

  public Integer getTotalCount() {
    return totalCount;
  }
}
