package stork;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class StorkApi {
    @RestClient
    MyService myService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String invoke() {
        return myService.get();
    }
}