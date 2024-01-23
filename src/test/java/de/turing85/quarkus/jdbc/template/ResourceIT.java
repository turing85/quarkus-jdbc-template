package de.turing85.quarkus.jdbc.template;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
@TestHTTPEndpoint(Resource.class)
class ResourceIT extends ResourceTest {
}
