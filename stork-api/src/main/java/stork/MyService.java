package stork;

import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "stork://my-service")
public interface MyService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String get();
}