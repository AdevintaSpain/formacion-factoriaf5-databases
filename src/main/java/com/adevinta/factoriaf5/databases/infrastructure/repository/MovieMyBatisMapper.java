package com.adevinta.factoriaf5.databases.infrastructure.repository;

import com.adevinta.factoriaf5.databases.domain.movie.request.SearchMovieRequest;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.AggregatedMovie;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.MovieRow;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieMyBatisMapper {

  Integer countMovies(SearchMovieRequest searchMovieRequest);

  Optional<AggregatedMovie> selectById(String id);

  List<AggregatedMovie> queryMovies(SearchMovieRequest searchMovieRequest);

  @Insert("insert into movie(id, title, synopsis, release_year)" +
        " values(#{id}, #{title}, #{synopsis}, #{releaseYear})")
  void insertMovie(MovieRow row);
}
