package sun.net.www.protocol.x;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.springframework.util.StreamUtils;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月24日
 */
public class HandlerTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("x:///META-INF/default.properties"); // 类似于 classpath:/META-INF/default.properties
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8));
    }
}
