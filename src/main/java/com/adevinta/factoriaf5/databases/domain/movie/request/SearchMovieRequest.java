package com.adevinta.factoriaf5.databases.domain.movie.request;

import com.adevinta.factoriaf5.databases.domain.core.Page;
import java.util.List;

public class SearchMovieRequest {

  private final String text;
  private final Integer minYear;
  private final Integer maxYear;
  private final List<String> platformIds;
  private final Page page;

  public SearchMovieRequest(String text, Integer minYear, Integer maxYear, List<String> platformIds, Page page) {
    this.text = text;
    this.minYear = minYear;
    this.maxYear = maxYear;
    this.platformIds = platformIds;
    this.page = page;
  }

  public String getText() {
    return text;
  }

  public Integer getMinYear() {
    return minYear;
  }

  public Integer getMaxYear() {
    return maxYear;
  }

  public List<String> getPlatformIds() {
    return platformIds;
  }

  public Page getPage() {
    return page;
  }
}
