package com.adevinta.factoriaf5.databases.testcases;

import org.springframework.test.context.jdbc.Sql;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = AbstractDatabaseTestCase.RESET_DB)
public abstract class AbstractDatabaseTestCase extends AbstractTestCase {

  static final String RESET_DB = "/db/db-reset-data.sql";
}
