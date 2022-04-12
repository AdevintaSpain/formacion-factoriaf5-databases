package com.adevinta.factoriaf5.databases.application.platform;

import com.adevinta.factoriaf5.databases.domain.core.EntityCollection;
import com.adevinta.factoriaf5.databases.domain.platform.Platform;
import com.adevinta.factoriaf5.databases.domain.platform.PlatformRepository;
import org.springframework.stereotype.Service;

@Service
public class GetPlatformsUseCase {

  private final PlatformRepository platformRepository;

  public GetPlatformsUseCase(PlatformRepository platformRepository) {
    this.platformRepository = platformRepository;
  }

  public EntityCollection<Platform> execute() {
    return platformRepository.findAll();
  }
}
