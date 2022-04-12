package com.adevinta.factoriaf5.databases.helper;

import java.io.File;
import org.testcontainers.containers.DockerComposeContainer;

public class DockerComposeHelper {

  public static DockerComposeContainer create() {
    return new DockerComposeContainer(new File("docker-compose.yml")).withLocalCompose(true);
  }
}
