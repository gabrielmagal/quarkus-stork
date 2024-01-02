package stork;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.consul.ServiceOptions;
import io.vertx.mutiny.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.mutiny.core.Vertx;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class Registration {
    @ConfigProperty(name = "quarkus.http.port") int quarkusPort;
    @ConfigProperty(name = "consul.host") String host;
    @ConfigProperty(name = "consul.port") int consulPort;
    public void init(@Observes StartupEvent ev, Vertx vertx) {
        ConsulClient client = ConsulClient.create(vertx, new ConsulClientOptions().setHost(host).setPort(consulPort));
        client.registerServiceAndAwait(
                new ServiceOptions().setPort(quarkusPort).setAddress("localhost").setName("my-service").setId("blue"));
    }
}