package com.adevinta.factoriaf5.databases.infrastructure.controller.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntityCollectionResource<T> {

  private Collection<T> collection = new ArrayList<>();
  private Integer pageSize;
  private Integer pageNumber;
  private Integer totalCount;

  public Collection<T> getCollection() {
    return collection;
  }

  public void setCollection(Collection<T> collection) {
    this.collection = collection;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }
}
