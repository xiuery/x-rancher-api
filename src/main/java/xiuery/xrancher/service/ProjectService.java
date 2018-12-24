package xiuery.xrancher.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProjectService {
    List<Map> getProjects();
    Map<String, String> getProject(String name);
}
