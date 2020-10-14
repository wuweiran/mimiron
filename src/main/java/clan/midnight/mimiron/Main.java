package clan.midnight.mimiron;

import org.restexpress.util.Environment;

/**
 * @author Midnight1000
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Configuration config = Environment.load(args, Configuration.class);
        Server server = new Server(config);
        server.start().awaitShutdown();
    }
}
