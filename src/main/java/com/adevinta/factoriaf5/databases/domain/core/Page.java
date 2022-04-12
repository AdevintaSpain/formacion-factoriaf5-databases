package com.adevinta.factoriaf5.databases.domain.core;

public class Page {

  private final Integer size;
  private final Integer number;
  private final Integer offset;

  public Page(Integer size, Integer number) {
    this.size = size;
    this.number = number;
    this.offset = size * number;
  }

  public Integer getSize() {
    return size;
  }

  public Integer getNumber() {
    return number;
  }

  public Integer getOffset() {
    return offset;
  }
}
