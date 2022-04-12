package com.adevinta.factoriaf5.databases.infrastructure.repository;

import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.FeaturetteRow;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FeaturetteMyBatisMapper {

  @Insert("insert into featurette(movie_id, item_order, name, url)" +
        " values(#{movieId}, #{itemOrder}, #{name}, #{url})")
  void insertFeaturette(FeaturetteRow row);

  @Select("select * from featurette where movie_id=#{id} order by item_order")
  List<FeaturetteRow> selectByMovieId(@Param("id") String id);
}
