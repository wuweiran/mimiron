package clan.midnight.mimiron;

import org.restexpress.RestExpress;
import org.restexpress.util.Environment;

import java.util.Properties;

/**
 * @author Midnight1000
 */
public class Configuration extends Environment {
    private static final String DEFAULT_EXECUTOR_THREAD_POOL_SIZE = "20";

    private static final String PORT_PROPERTY = "8081";
    private static final String BASE_URL_PROPERTY = "http://localhost:";
    private static final String EXECUTOR_THREAD_POOL_SIZE = "10";

    private static final String PATH_TO_DB = "D:/mimiron_db";

    private int port;
    private String baseUrl;
    private int executorThreadPoolSize;

    private CoreController coreController;

    @Override
    protected void fillValues(Properties p) {
        this.port = Integer.parseInt(p.getProperty(PORT_PROPERTY, String.valueOf(RestExpress.DEFAULT_PORT)));
        this.baseUrl = p.getProperty(BASE_URL_PROPERTY, "http://localhost:" + port);
        this.executorThreadPoolSize = Integer.parseInt(p.getProperty(EXECUTOR_THREAD_POOL_SIZE, DEFAULT_EXECUTOR_THREAD_POOL_SIZE));
        initialize();
    }

    private void initialize() {
        coreController = new CoreController(PATH_TO_DB);
    }

    public int getPort() {
        return port;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getExecutorThreadPoolSize() {
        return executorThreadPoolSize;
    }

    public CoreController getCoreController() {
        return coreController;
    }
}
