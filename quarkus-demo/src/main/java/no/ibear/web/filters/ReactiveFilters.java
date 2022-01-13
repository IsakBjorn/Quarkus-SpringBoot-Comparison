package no.ibear.web.filters;

import java.net.URI;
import java.util.Optional;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;
import org.jboss.resteasy.reactive.server.ServerResponseFilter;

public class ReactiveFilters {


  @ServerRequestFilter(preMatching = true)
  public void preMatchingFilter(ContainerRequestContext requestContext) {

    requestContext.setProperty("started_at", System.currentTimeMillis());
  }


  @ServerResponseFilter
  public void preMatchingFilter(ContainerResponseContext context) {

  }

}
