package com.mycompany.mavenproject1.ping.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.mavenproject1.ping.model.Greeting;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author hassannazar.net
 */
@Timed
@Path("ping")
public class PingResource {

    @Inject
    @ConfigProperty(name = "message")
    String message;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting ping() {
        return new Greeting(message);
    }

}
