package com.adevinta.factoriaf5.databases.infrastructure.repository;

import com.adevinta.factoriaf5.databases.domain.core.EntityCollection;
import com.adevinta.factoriaf5.databases.domain.platform.Platform;
import com.adevinta.factoriaf5.databases.domain.platform.PlatformRepository;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.PlatformRow;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class PlatformMyBatisRepository implements PlatformRepository {

  private final PlatformMyBatisMapper platformMyBatisMapper;

  public PlatformMyBatisRepository(PlatformMyBatisMapper platformMyBatisMapper) {
    this.platformMyBatisMapper = platformMyBatisMapper;
  }

  @Override
  public EntityCollection<Platform> findAll() {
    List<PlatformRow> rows = platformMyBatisMapper.findAll();
    List<Platform> platforms = rows.stream().map(this::toPlatform).collect(Collectors.toList());
    return new EntityCollection<>(platforms);
  }

  private Platform toPlatform(PlatformRow row) {
    return new Platform(row.getId(), row.getName());
  }
}
