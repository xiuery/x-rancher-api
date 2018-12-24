package xiuery.xrancher.service.impl;

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

        for (int i =0; i < 3; i++){
            Map<String, String> p = new HashMap<>();
            p.put("B1", "B1");
            p.put("B2", "B2");
            p.put("B3", "B3");

            Map<String, Map<String, String>> project = new HashMap<>();
            project.put("A", p);

            projects.add(project);
        }

        return projects;
    }

    public Map<String, String> getProject(String name){
        Map<String, String> p = new HashMap<>();
        p.put("B1", "B1");
        p.put("B2", "B2");
        p.put("B3", "B3");

        httpRequest.get("http://127.0.0.1:8080/project");

        return p;
    }
}
