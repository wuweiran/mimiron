package clan.midnight.mimiron;

/**
 * @author Midnight1000
 */
public class Constants {
    /**
     * These define the URL parameters used in the route definition strings (e.g. '{userId}').
     */
    public static class Url {
        public static final String PARAMETER_KEY = "k";
        public static final String PARAMETER_VALUE = "v";
    }

    /**
     * These define the route names used in naming each route definitions.  These names are used
     * to retrieve URL patterns within the controllers by name to create links in responses.
     */
    public static class Routes {
        public static final String CORE_SINGLE = "core.single";
        public static final String CORE_BATCH = "core.batch";
    }
}
