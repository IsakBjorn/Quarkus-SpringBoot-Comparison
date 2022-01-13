package no.ibear.web.filters;

import io.quarkus.vertx.web.RouteFilter;
import io.vertx.ext.web.RoutingContext;
import java.util.UUID;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VertXRouteFilters {

  private static final Logger log = LoggerFactory.getLogger(VertXRouteFilters.class);

  @RouteFilter(500)
  void loggingFilter(RoutingContext rc) {
    MDC.put("request_id", UUID.randomUUID().toString());
    final var method = rc.request().method().toString();
    final var path = rc.request().path();
    log.info("Request: {} {}", method, path);
    rc.next();
  }

}
