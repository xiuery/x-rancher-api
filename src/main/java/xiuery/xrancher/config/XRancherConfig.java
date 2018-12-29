package xiuery.xrancher.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(
    prefix = "x-config.rancher-server"
)
public class XRancherConfig {

    /**
     * rancher 服务器地址
     */
    private String url;

    /**
    * token
    */
    private String token;

    /**
     * header
     */
    private String contentType;
}
