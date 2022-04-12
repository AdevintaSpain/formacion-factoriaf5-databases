package com.adevinta.factoriaf5.databases.domain.platform;

import com.adevinta.factoriaf5.databases.domain.core.EntityCollection;

public interface PlatformRepository {

  EntityCollection<Platform> findAll();
}
