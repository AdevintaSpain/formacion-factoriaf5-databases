package com.adevinta.factoriaf5.databases.testcases;

import com.adevinta.factoriaf5.databases.FormacionApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
      classes = FormacionApplication.class,
      properties = "spring.profiles.active=test"
)
@AutoConfigureMockMvc
public abstract class AbstractTestCase {

  @Autowired
  private MockMvc mvc;

  @BeforeEach
  public void beforeEach() {
    RestAssuredMockMvc.mockMvc(mvc);
  }
}
