package clan.midnight.mimiron;

import clan.midnight.mimiron.serialization.SerializationProvider;
import org.restexpress.RestExpress;
import org.restexpress.pipeline.SimpleConsoleLogMessageObserver;

/**
 * @author Midnight1000
 */
public class Server {
    private static final String SERVICE_NAME = "Mimiron Server";

    private final RestExpress server;
    private final Configuration config;
    private boolean isStarted = false;

    public Server(Configuration config) {
        this.config = config;
        RestExpress.setDefaultSerializationProvider(new SerializationProvider());

        this.server = new RestExpress()
                .setName(SERVICE_NAME)
                .setBaseUrl(config.getBaseUrl())
                .setExecutorThreadCount(config.getExecutorThreadPoolSize())
                .addMessageObserver(new SimpleConsoleLogMessageObserver());

        Routes.define(config, server);
    }

    public Server start() {
        if (!isStarted) {
            server.bind(config.getPort());
            isStarted = true;
        }

        return this;
    }

    public void awaitShutdown() {
        if (isStarted) {
            server.awaitShutdown();
        }
    }

    public void shutdown() {
        if (isStarted) {
            server.shutdown();
        }
    }
}
