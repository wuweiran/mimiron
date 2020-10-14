package clan.midnight.mimiron.serialization;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.restexpress.serialization.json.JacksonJsonProcessor;

/**
 * @author Midnight1000
 */
public class JsonSerializationProcessor
        extends JacksonJsonProcessor {
    @Override
    protected void initializeModule(SimpleModule module) {
        super.initializeModule(module);
    }
}
