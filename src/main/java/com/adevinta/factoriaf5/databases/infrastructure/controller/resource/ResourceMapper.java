package com.adevinta.factoriaf5.databases.infrastructure.controller.resource;

import com.adevinta.factoriaf5.databases.domain.movie.Featurette;
import com.adevinta.factoriaf5.databases.domain.movie.Movie;
import com.adevinta.factoriaf5.databases.domain.platform.Platform;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {

  public PlatformResource map(Platform platform) {
    PlatformResource resource = new PlatformResource();
    resource.setId(platform.getId());
    resource.setName(platform.getName());
    return resource;
  }

  public MovieResource map(Movie movie) {
    MovieResource resource = new MovieResource();
    resource.setId(movie.getId());
    resource.setTitle(movie.getTitle());
    resource.setSynopsis(movie.getSynopsis());
    resource.setReleaseYear(movie.getReleaseYear());
    resource.setFeaturettes(movie.getFeaturettes().stream().map(this::map).collect(Collectors.toList()));
    resource.setPlatforms(movie.getPlatforms().stream().map(this::map).collect(Collectors.toList()));
    return resource;
  }

  public FeaturetteResource map(Featurette featurette) {
    FeaturetteResource resource = new FeaturetteResource();
    resource.setName(featurette.getName());
    resource.setUrl(featurette.getUrl());
    return resource;
  }
}
