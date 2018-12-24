package xiuery.xrancher.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.pkulak.httpclient.HttpClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HttpRequest {

    private HttpClient<Object, JsonNode> httpRequest;

    public HttpRequest(){
        httpRequest = HttpClient.createDefault();
    }

    public HttpRequest(Map<String, Object> headers){
        this();

        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            httpRequest = httpRequest.addHeader(entry.getKey(), entry.getValue());
        }
    }

    public HttpRequest(Map<String, Object> headers, String url){
        this(headers);
        httpRequest = httpRequest.url(url);
    }

    public HttpRequest(Map<String, Object> headers, String url, String method){
        this(headers, url);
        httpRequest = httpRequest.method(method);
    }

    public HttpRequest(Map<String, Object> headers, String url, String method, Map<String, Object> params){
        this(headers, url, method);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            httpRequest = httpRequest.pathParam(entry.getKey(), entry.getValue());
        }
    }

    public void addHeader(Map<String, Object> headers){
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            httpRequest = httpRequest.addHeader(entry.getKey(), entry.getValue());
        }
    }

    public void execute(){
        JsonNode response = this.httpRequest.execute();
        System.out.println(response.toString());
    }

    public JsonNode get(String url){
        return this.httpRequest.url(url).get();
    }

//     public void post(String contentType, T<> requestBody){
//         JsonNode response = this.httpRequest.post(contentType, requestBody);
//         System.out.println(response.toString());
//     }

    public void delete(){
        JsonNode response = this.httpRequest.delete();
        System.out.println(response.toString());
    }

}
