package xiuery.xrancher.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xiuery.xrancher.service.ProjectService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /*
     * 获取集群所有项目
     */
    @GetMapping("")
    public List<Map> index() {
        return projectService.getProjects();
    }

    @GetMapping("/{name}")
    public Map<String, Object> show(@PathVariable String name) {
        return projectService.getProject(name);
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable String name) {
        projectService.delete(name);
    }
}
