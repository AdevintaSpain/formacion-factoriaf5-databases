package com.adevinta.factoriaf5.databases;

import com.adevinta.factoriaf5.databases.helper.DockerComposeHelper;
import com.adevinta.factoriaf5.databases.testcases.ApplicationContextTestCase;
import com.adevinta.factoriaf5.databases.testcases.PlatformControllerTestCases;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.testcontainers.containers.DockerComposeContainer;

class FormacionApplicationTests {

  private static DockerComposeContainer container = DockerComposeHelper.create();

  @BeforeAll
  public static void beforeAll() {
    container.start();
  }

  @AfterAll
  public static void afterAll() {
    container.stop();
  }

  @Nested
  class ApplicationContext extends ApplicationContextTestCase {
  }

  @Nested
  class PlatformController extends PlatformControllerTestCases {
  }
}
