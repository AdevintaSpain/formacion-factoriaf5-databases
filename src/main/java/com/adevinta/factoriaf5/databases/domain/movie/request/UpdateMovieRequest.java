package com.adevinta.factoriaf5.databases.domain.movie.request;

import com.adevinta.factoriaf5.databases.domain.movie.Featurette;
import java.util.List;

public class UpdateMovieRequest extends AddMovieRequest{

  private final String id;

  public UpdateMovieRequest(String title, String synopsis, Integer releaseYear, List<Featurette> featurettes, List<String> platformIds, String id) {
    super(title, synopsis, releaseYear, featurettes, platformIds);
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
