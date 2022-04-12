package com.adevinta.factoriaf5.databases.infrastructure.repository;

import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.MoviePlatformRow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoviePlatformMyBatisMapper {

  @Insert("insert into movie_platform(movie_id, platform_id)" +
        " values(#{movieId}, #{platformId})")
  void insertMoviePlatform(MoviePlatformRow row);
}
