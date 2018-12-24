package xiuery.xrancher.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiuery.xrancher.common.HttpRequest;
import xiuery.xrancher.service.ProjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private HttpRequest httpRequest;

    public List<Map> getProjects(){
        List<Map> projects = new ArrayList<>();

//        for (int i =0; i < 3; i++){
//            Map<String, String> p = new HashMap<>();
//            p.put("B1", "B1");
//            p.put("B2", "B2");
//            p.put("B3", "B3");
//
//            Map<String, Map<String, String>> project = new HashMap<>();
//            project.put("A", p);
//
//            projects.add(project);
//        }

        Map<String, Object> headers= new HashMap<>();
        headers.put("Content-Type", "application/json");
        // https://10.0.0.11:10443/v3
        // Access Key: token-7lvdq
        // Secret Key: fzxxd6dmvbngtv4thjzm4zt5nq5sr629kpjrlfvbh94dk2vr8f6bkv
        // token-7lvdq:fzxxd6dmvbngtv4thjzm4zt5nq5sr629kpjrlfvbh94dk2vr8f6bkv
        headers.put("Authorization", "Bearer token-7lvdq:fzxxd6dmvbngtv4thjzm4zt5nq5sr629kpjrlfvbh94dk2vr8f6bkv");

        httpRequest.addHeader(headers);
        JsonNode response = httpRequest.get("https://10.0.0.11:10443/v3/projects");
        System.out.println(response);

        return projects;
    }

    public Map<String, Object> getProject(String name){
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

    public void delete(String name){

    }
}
