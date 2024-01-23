package de.turing85.quarkus.jdbc.template;

import jakarta.ws.rs.core.Response;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(Resource.class)
class ResourceTest {
  @Test
  void get() {
    // @formatter:off
    RestAssured
        .when().get()
        .then()
          .statusCode(Response.Status.OK.getStatusCode())
          .contentType(ContentType.TEXT_PLAIN.getMimeType())
          .body(is("1, 2, 3"));
    // @formatter:on
  }
}
