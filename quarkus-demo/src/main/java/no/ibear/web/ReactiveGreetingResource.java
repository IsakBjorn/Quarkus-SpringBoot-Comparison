package no.ibear.web;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import no.ibear.config.GreetingConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")

public class ReactiveGreetingResource {
    private static final Logger log = LoggerFactory.getLogger(ReactiveGreetingResource.class);
    private final GreetingConfiguration configuration;

    public ReactiveGreetingResource(GreetingConfiguration configuration) {
        this.configuration = configuration;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        var greetingsBuilder = new StringBuilder(configuration.greeting()).append(' ')
            .append(configuration.getSuffix()).append(' ');
        configuration.getName().ifPresent(str -> greetingsBuilder.append(str).append(" "));
        greetingsBuilder.append("from a worker thread");

        log.info("Worker thread");
        return greetingsBuilder.toString();
    }

    @GET
    @NonBlocking
    @Path("/nb")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloNonBlocking() {
        log.info("Hello on IO thread");
        return "Reactive hello from IO thread";
    }

    @GET
    @Path("/smallrye")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> helloWithSmallRye() {
        log.info("SmallRye");
        return Uni.createFrom().item("Reactive smallrye");
    }
}
