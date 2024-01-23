package de.turing85.quarkus.jdbc.template;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import io.agroal.api.AgroalDataSource;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@Path(Resource.ENDPOINT)
@Produces(MediaType.TEXT_PLAIN)
@AllArgsConstructor
public class Resource {
  public static final String ENDPOINT = "foo";

  private final AgroalDataSource dataSource;

  @GET
  public String get() {
    JdbcTemplate template = new JdbcTemplate(dataSource);
    SqlRowSet set = template.queryForRowSet("SELECT id FROM public.foo;");
    List<Integer> results = new ArrayList<>();
    while (set.next()) {
      results.add(set.getInt("id"));
    }
    return results.stream().map(Object::toString).collect(Collectors.joining(", "));
  }
}
