package sun.net.www.protocol.x;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.core.io.ClassPathResource;

/**
 * X {@link URLConnection} 实现
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年09月24日
 */
public class XURLConnection extends URLConnection {

    private final ClassPathResource resource;

    /**
     * Constructs a URL connection to the specified URL. A connection to the object referenced by the URL is not
     * created.
     *
     * @param url the specified URL.
     */

    // URL = x:///META-INF/default.properties
    protected XURLConnection(URL url) {
        super(url);
        this.resource = new ClassPathResource(url.getPath());
    }

    @Override
    public void connect() throws IOException {

    }

    public InputStream getInputStream() throws IOException {
        return resource.getInputStream();
    }
}
