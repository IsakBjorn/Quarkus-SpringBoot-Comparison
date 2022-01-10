package no.ibear;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")

public class ReactiveGreetingResource {
    Logger log = LoggerFactory.getLogger(ReactiveGreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        log.info("Hello on worker thread");
        return "Hello RESTEasy Reactive on worked thread;";
    }

    @GET
    @NonBlocking
    @Path("/nb")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloNonBlocking() {
        log.info("Hello on IO thread");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello RESTEasy non blocking";
    }

    @GET
    @Path("/smallrye")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> helloWithSmallRye() {
        log.info("Hello on IO thread");
        return Uni.createFrom().item("Hello non blocking");
    }

    @POST
    public Response addName() {
        return Response.accepted().build();
    }

    @PUT
    public Response updateName() {
        return Response.accepted().build();
    }

    @DELETE
    public Response delete() {
        return Response.noContent().build();
    }
}
