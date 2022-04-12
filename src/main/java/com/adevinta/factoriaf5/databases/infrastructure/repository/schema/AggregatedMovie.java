package com.adevinta.factoriaf5.databases.infrastructure.repository.schema;

import java.util.ArrayList;
import java.util.List;

public class AggregatedMovie extends MovieRow {

  private List<FeaturetteRow> featurettes = new ArrayList<>();
  private List<PlatformRow> platforms = new ArrayList<>();

  public List<FeaturetteRow> getFeaturettes() {
    return featurettes;
  }

  public void setFeaturettes(List<FeaturetteRow> featurettes) {
    this.featurettes = featurettes;
  }

  public List<PlatformRow> getPlatforms() {
    return platforms;
  }

  public void setPlatforms(List<PlatformRow> platforms) {
    this.platforms = platforms;
  }
}
