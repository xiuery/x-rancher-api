package xiuery.xrancher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import xiuery.xrancher.common.HttpClient;
import xiuery.xrancher.config.XRancherConfig;
import xiuery.xrancher.service.ProjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private XRancherConfig xRancherConfig;

    private Map<String, String> params = new HashMap<>();

    private Map<String, String> body = new HashMap<>();

    private MultiValueMap<String, String> getHeaders() {
        // LinkedMultiValueMap实现了MultiValueMap接口
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

        headers.add("Content-Type", xRancherConfig.getContentType());
        // headers.add("Authorization", "Bearer " + xRancherConfig.getToken());

        return headers;
    }

    public List<Map> getProjects() {
        List<Map> projects = new ArrayList<>();

        Map<String, Object> responseBody = httpClient.doGet(xRancherConfig.getUrl() + "/v3/projects", getHeaders(), params);

        for (Map.Entry<String, Object> entry : responseBody.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println(responseBody);

        return projects;
    }

    public Map<String, Object> getProject(String name) {
        Map<String, Object> p2 = new HashMap<>();
        p2.put("B1", "B1");
        p2.put("B2", "B2");
        p2.put("B3", "B3");

        Map<String, Object> p = new HashMap<>();
        p.put("B1", p2);
        p.put("B2", "B2");
        p.put("B3", "B3");

        return p;
    }

    public void delete(String name) {

    }
}
