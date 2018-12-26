package xiuery.xrancher.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

/**
 * https://www.programcreek.com/java-api-examples/index.php?api=org.springframework.http.RequestEntity
 */
@Component
public class HttpClient {

    @Autowired
    private RestTemplate restTemplate;

    private URI createURI(String url) {
        try {
            return  URI.create(url);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("URI构建失败");
        }
    }

    private RequestEntity createRequestEntity( MultiValueMap<String, String> headers, HttpMethod method, String url) {
        return new RequestEntity<>(headers, method, createURI(url));
    }

    public Map<String, Object> doGet(String url, MultiValueMap<String, String> headers, Map<String, String> params){

        RequestEntity requestEntity = createRequestEntity(headers, HttpMethod.GET, url);

        ParameterizedTypeReference<Map<String, Object>> paramTypeRef = new ParameterizedTypeReference<Map<String, Object>>() {};
        ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(requestEntity, paramTypeRef);

        return responseEntity.getBody();
    }

    public void doPost(String url, MultiValueMap<String, String> headers, Map<String, String> body) {

        RequestEntity requestEntity = createRequestEntity(headers, HttpMethod.POST, url);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(requestEntity, Object.class);

        Object responseBody = responseEntity.getBody();
        System.out.println(responseBody);
    }

}
