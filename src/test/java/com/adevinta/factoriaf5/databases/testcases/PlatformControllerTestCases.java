package com.adevinta.factoriaf5.databases.testcases;

import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.EntityCollectionResource;
import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.PlatformResource;
import com.adevinta.factoriaf5.databases.infrastructure.repository.PlatformMyBatisMapper;
import com.adevinta.factoriaf5.databases.infrastructure.repository.schema.PlatformRow;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

abstract public class PlatformControllerTestCases extends AbstractTestCase {

  @Autowired
  private PlatformMyBatisMapper platformMyBatisMapper;

  @Test
  void shouldGetThePlatforms() {
    EntityCollectionResource<PlatformResource> apiPlatforms = given()
          .when()
          .get("/platform")
          .then()
          .assertThat(status().isOk())
          .extract().body().as(new TypeRef<>() {
          });
    List<PlatformRow> dbPlatforms = platformMyBatisMapper.findAll();
    assertThat(apiPlatforms.getCollection().size()).isEqualTo(dbPlatforms.size());
  }
}
