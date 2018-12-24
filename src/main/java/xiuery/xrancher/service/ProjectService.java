package xiuery.xrancher.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProjectService {
    List<Map> getProjects();
    Map<String, Object> getProject(String name);
    void delete(String name);
}
