package com.adevinta.factoriaf5.databases.application.movie;

import com.adevinta.factoriaf5.databases.domain.movie.Movie;
import com.adevinta.factoriaf5.databases.domain.movie.MovieRepository;
import com.adevinta.factoriaf5.databases.domain.movie.request.AddMovieRequest;
import org.springframework.stereotype.Service;

@Service
public class AddMovieUseCase {

  private final MovieRepository movieRepository;

  public AddMovieUseCase(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public Movie execute(AddMovieRequest addMovieRequest) {
    String id = movieRepository.save(addMovieRequest);
    return movieRepository.findById(id).get();
  }
}
