package com.adevinta.factoriaf5.databases.application.movie;

import com.adevinta.factoriaf5.databases.domain.core.NotFoundException;
import com.adevinta.factoriaf5.databases.domain.movie.Movie;
import com.adevinta.factoriaf5.databases.domain.movie.MovieRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LoadMovieUseCase {

  private final MovieRepository movieRepository;

  public LoadMovieUseCase(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public Movie execute(String id) {
    Optional<Movie> maybeMovie = movieRepository.findById(id);
    maybeMovie.orElseThrow(() -> new NotFoundException("movie#" + id));
    return maybeMovie.get();
  }
}
