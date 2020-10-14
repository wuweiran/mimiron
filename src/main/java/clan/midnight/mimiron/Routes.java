package clan.midnight.mimiron;

import io.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;

/**
 * @author Midnight1000
 */
public final class Routes {
    public static void define(Configuration config, RestExpress server) {
        server.uri("/", config.getCoreController())
                .method(HttpMethod.PUT).method(HttpMethod.GET).method(HttpMethod.DELETE)
                .name(Constants.Routes.CORE_SINGLE).noSerialization();

//        server.uri("/your/route/here.{format}", config.getCoreController())
//                .action("readAll", HttpMethod.GET)
//                .method(HttpMethod.POST)
//                .name(Constants.Routes.SAMPLE_COLLECTION);
    }
}
