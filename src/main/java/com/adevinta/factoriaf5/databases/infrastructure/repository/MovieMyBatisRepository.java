package com.adevinta.factoriaf5.databases.infrastructure.repository;

import com.adevinta.factoriaf5.databases.domain.core.PagedEntityCollection;
import com.adevinta.factoriaf5.databases.domain.movie.Featurette;
import com.adevinta.factoriaf5.databases.domain.movie.Movie;
import com.adevinta.factoriaf5.databases.domain.movie.MovieRepository;
import com.adevinta.factoriaf5.databases.domain.movie.request.AddMovieRequest;
import com.adevinta.factoriaf5.databases.domain.movie.request.SearchMovieRequest;
import com.adevinta.factoriaf5.databases.domain.platform.Platform;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.FeaturetteRow;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.MoviePlatformRow;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.MovieRow;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.PlatformRow;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class MovieMyBatisRepository implements MovieRepository {

  private final MovieMyBatisMapper movieMyBatisMapper;
  private final FeaturetteMyBatisMapper featuretteMyBatisMapper;
  private final MoviePlatformMyBatisMapper moviePlatformMyBatisMapper;
  private final PlatformMyBatisMapper platformMyBatisMapper;

  public MovieMyBatisRepository(MovieMyBatisMapper movieMyBatisMapper,
                                FeaturetteMyBatisMapper featuretteMyBatisMapper,
                                MoviePlatformMyBatisMapper moviePlatformMyBatisMapper,
                                PlatformMyBatisMapper platformMyBatisMapper) {
    this.movieMyBatisMapper = movieMyBatisMapper;
    this.featuretteMyBatisMapper = featuretteMyBatisMapper;
    this.moviePlatformMyBatisMapper = moviePlatformMyBatisMapper;
    this.platformMyBatisMapper = platformMyBatisMapper;
  }

  @Override
  public Optional<Movie> findById(String id) {
    return movieMyBatisMapper.selectById(id)
          .map(this::toMovie);
  }

  @Override
  public PagedEntityCollection<Movie> find(SearchMovieRequest searchMovieRequest) {
    Integer totalRows = movieMyBatisMapper.countMovies(searchMovieRequest);
    List<MovieRow> movieRows = totalRows > 0 ? movieMyBatisMapper.queryMovies(searchMovieRequest) : new ArrayList<>();
    List<Movie> movies = movieRows.stream().map(this::toMovie).collect(Collectors.toList());
    return new PagedEntityCollection<>(searchMovieRequest.getPage(), totalRows, movies);
  }

  @Override
  public String save(AddMovieRequest addMovieRequest) {
    MovieRow movieRow = new MovieRow();
    movieRow.setTitle(addMovieRequest.getTitle());
    movieRow.setSynopsis(addMovieRequest.getSynopsis());
    movieRow.setReleaseYear(addMovieRequest.getReleaseYear());
    movieMyBatisMapper.insertMovie(movieRow);

    AtomicInteger featuretteItemOrder = new AtomicInteger();
    addMovieRequest.getFeaturettes().forEach(featurette -> {
      FeaturetteRow featuretteRow = new FeaturetteRow();
      featuretteRow.setMovieId(movieRow.getId());
      featuretteRow.setItemOrder(featuretteItemOrder.incrementAndGet());
      featuretteRow.setName(featurette.getName());
      featuretteRow.setUrl(featurette.getUrl());
      featuretteMyBatisMapper.insertFeaturette(featuretteRow);
    });

    addMovieRequest.getPlatformIds().forEach(platformId -> {
      MoviePlatformRow moviePlatformRow = new MoviePlatformRow();
      moviePlatformRow.setMovieId(movieRow.getId());
      moviePlatformRow.setPlatformId(platformId);
      moviePlatformMyBatisMapper.insertMoviePlatform(moviePlatformRow);
    });

    return movieRow.getId();
  }

  private Movie toMovie(MovieRow movieRow) {
    List<FeaturetteRow> featuretteRows = featuretteMyBatisMapper.selectByMovieId(movieRow.getId());
    List<Featurette> featurettes = featuretteRows.stream().map(row -> new Featurette(row.getName(), row.getUrl())).collect(Collectors.toList());

    List<PlatformRow> platformRows = platformMyBatisMapper.selectByMovieId(movieRow.getId());
    List<Platform> platforms = platformRows.stream().map(row -> new Platform(row.getId(), row.getName())).collect(Collectors.toList());

    return new Movie(
          movieRow.getId(),
          movieRow.getTitle(),
          movieRow.getSynopsis(),
          movieRow.getReleaseYear(),
          featurettes,
          platforms
    );
  }
}
