package clan.midnight.mimiron;

import io.netty.handler.codec.http.HttpResponseStatus;
import org.restexpress.Request;
import org.restexpress.Response;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static clan.midnight.mimiron.Constants.Url.*;

/**
 * @author Midnight1000
 */
public class CoreController {
    private RocksDB db;

    public CoreController(String path) {
        RocksDB.loadLibrary();
        try {
            final Options options = new Options().setCreateIfMissing(true);
            this.db = RocksDB.open(options, path);
        } catch (RocksDBException ex) {
            ex.printStackTrace();
        }
    }

    public Object create(Request request, Response response) {
        //TODO: Your 'POST' logic here...
        return null;
    }

    public Object read(Request request, Response response) {
        Map<String, String> map = request.getQueryStringMap();
        String key = map.get(PARAMETER_KEY);
        byte[] values;
        try {
            values = db.get(key.getBytes());
            if (values != null) {
                response.setResponseStatus(HttpResponseStatus.OK);
                return new String(values, StandardCharsets.UTF_8);
            } else {
                response.setResponseNoContent();
                return null;
            }
        } catch (RocksDBException e) {
            response.setResponseStatus(HttpResponseStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    public void update(Request request, Response response) {
        Map<String, String> map = request.getQueryStringMap();
        String key = map.get(PARAMETER_KEY);
        String value = map.get(PARAMETER_VALUE);
        if (key == null || value == null) {
            response.setResponseStatus(HttpResponseStatus.BAD_REQUEST);
            return;
        }

        try {
            db.put(key.getBytes(), value.getBytes());
        } catch (RocksDBException e) {
            response.setResponseStatus(HttpResponseStatus.INTERNAL_SERVER_ERROR);
        }
        response.setResponseStatus(HttpResponseStatus.OK);
    }

    public void delete(Request request, Response response) {
        Map<String, String> map = request.getQueryStringMap();
        String key = map.get(PARAMETER_KEY);
        try {
            db.delete(key.getBytes());
            response.setResponseStatus(HttpResponseStatus.OK);
        } catch (RocksDBException e) {
            response.setResponseStatus(HttpResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
