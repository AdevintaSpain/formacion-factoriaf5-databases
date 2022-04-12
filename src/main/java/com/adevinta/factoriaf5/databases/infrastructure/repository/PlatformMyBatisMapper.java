package com.adevinta.factoriaf5.databases.infrastructure.repository;

import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.PlatformRow;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PlatformMyBatisMapper {

  @Select("select * from platform order by name")
  List<PlatformRow> findAll();

  @Select("select p.* from platform p inner join movie_platform mp on p.id=mp.platform_id where mp.movie_id=#{movieId}")
  List<PlatformRow> selectByMovieId(@Param("movieId") String movieId);
}
