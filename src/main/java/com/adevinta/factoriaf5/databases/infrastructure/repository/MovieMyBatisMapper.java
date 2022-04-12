package com.adevinta.factoriaf5.databases.infrastructure.repository;

import com.adevinta.factoriaf5.databases.domain.movie.request.SearchMovieRequest;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.MovieRow;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MovieMyBatisMapper {

  @Select("select * from movie where id=#{id}")
  Optional<MovieRow> selectById(String id);

  Integer countMovies(SearchMovieRequest searchMovieRequest);

  List<MovieRow> queryMovies(SearchMovieRequest searchMovieRequest);

  @Insert("insert into movie(id, title, synopsis, release_year)" +
        " values(#{id}, #{title}, #{synopsis}, #{releaseYear})")
  void insertMovie(MovieRow row);
}
