package xiuery.xrancher.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * RestTemplate客户端连接池配置
 * https://github.com/yidao620c/SpringBootBucket/tree/master/springboot-resttemplate
 * 需要导入：
 *  <dependency>
 *      <groupId>org.springframework.boot</groupId>
 * 		<artifactId>spring-boot-starter-aop</artifactId>
 * 	</dependency>
 * 	<dependency>
 * 	    <groupId>org.apache.httpcomponents</groupId>
 * 		<artifactId>httpclient</artifactId>
 * 		<version>4.5.6</version>
 * 	</dependency>
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RestTemplateConfig {

    @Resource
    private CloseableHttpClient closeableHttpClient;

    @Bean
    public RestTemplate restTemplate(MappingJackson2HttpMessageConverter jackson2HttpMessageConverter) {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("utf-8"));
        messageConverters.add(stringHttpMessageConverter);
        messageConverters.add(jackson2HttpMessageConverter);
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory();
        rf.setHttpClient(closeableHttpClient);
        return rf;
    }

}
