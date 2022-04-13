package com.adevinta.factoriaf5.databases.domain.movie;

import com.adevinta.factoriaf5.databases.domain.core.PagedEntityCollection;
import com.adevinta.factoriaf5.databases.domain.movie.request.AddMovieRequest;
import com.adevinta.factoriaf5.databases.domain.movie.request.SearchMovieRequest;
import java.util.Optional;

public interface MovieRepository {

  Optional<Movie> findById(String id);

  PagedEntityCollection<Movie> find(SearchMovieRequest searchMovieRequest);

  String save(AddMovieRequest addMovieRequest);
}
