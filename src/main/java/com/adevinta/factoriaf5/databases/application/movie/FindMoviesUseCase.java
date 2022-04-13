package com.adevinta.factoriaf5.databases.application.movie;

import com.adevinta.factoriaf5.databases.domain.core.PagedEntityCollection;
import com.adevinta.factoriaf5.databases.domain.movie.Movie;
import com.adevinta.factoriaf5.databases.domain.movie.MovieRepository;
import com.adevinta.factoriaf5.databases.domain.movie.request.SearchMovieRequest;
import org.springframework.stereotype.Service;

@Service
public class FindMoviesUseCase {

  private final MovieRepository movieRepository;

  public FindMoviesUseCase(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public PagedEntityCollection<Movie> execute(SearchMovieRequest searchMovieRequest) {
    return movieRepository.find(searchMovieRequest);
  }
}
