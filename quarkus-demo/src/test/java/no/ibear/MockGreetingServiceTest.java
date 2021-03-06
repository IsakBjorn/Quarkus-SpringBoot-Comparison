package no.ibear;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class MockGreetingServiceTest {

  @InjectMock
  GreetingService greetingService;

  @Test
  public void testGreeting() {
    when(greetingService.greet()).thenReturn("hi");
    given()
        .when().get("/greeting")
        .then()
        .statusCode(200)
        .body(is("hi"));
  }

  @Path("greeting")
  public static class GreetingResource {

    final GreetingService greetingService;

    public GreetingResource(GreetingService greetingService) {
      this.greetingService = greetingService;
    }

    @GET
    @Produces("text/plain")
    public String greet() {
      return greetingService.greet();
    }
  }

  @ApplicationScoped
  public static class GreetingService {
    public String greet(){
      return "hello";
    }
  }
}

