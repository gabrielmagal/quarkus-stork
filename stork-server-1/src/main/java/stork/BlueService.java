package stork;

import io.quarkus.runtime.StartupEvent;
import io.vertx.mutiny.core.Vertx;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class BlueService {
    @ConfigProperty(name = "blue-service-port", defaultValue = "9000") int port;

    public void init(@Observes StartupEvent ev, Vertx vertx) {
        vertx.createHttpServer()
                .requestHandler(req -> req.response().endAndForget("Hello from Blue!"))
                .listenAndAwait(port);
    }
}