package com.adevinta.factoriaf5.databases.infrastructure.controller;

import com.adevinta.factoriaf5.databases.application.platform.GetPlatformsUseCase;
import com.adevinta.factoriaf5.databases.domain.core.EntityCollection;
import com.adevinta.factoriaf5.databases.domain.platform.Platform;
import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.EntityCollectionResource;
import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.PlatformResource;
import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.ResourceMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class PlatformController {

  private final ResourceMapper resourceMapper;
  private final GetPlatformsUseCase getPlatformsUseCase;

  public PlatformController(ResourceMapper resourceMapper,
                            GetPlatformsUseCase getPlatformsUseCase) {
    this.resourceMapper = resourceMapper;
    this.getPlatformsUseCase = getPlatformsUseCase;
  }

  @GetMapping
  public EntityCollectionResource<PlatformResource> getPlatformsCollection() {
    EntityCollection<Platform> entityCollection = getPlatformsUseCase.execute();
    EntityCollectionResource<PlatformResource> resource = new EntityCollectionResource<>();
    List<PlatformResource> platformResources = entityCollection.getCollection().stream()
          .map(resourceMapper::map)
          .collect(Collectors.toList());
    resource.setCollection(platformResources);
    return resource;
  }
}
