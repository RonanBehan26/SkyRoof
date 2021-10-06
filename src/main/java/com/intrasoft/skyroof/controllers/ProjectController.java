package com.intrasoft.skyroof.controllers;

import com.intrasoft.skyroof.entities.Project;
import com.intrasoft.skyroof.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")//works
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/project/{id}")//works
    public Project getProject(@PathVariable("id") Long id) {
        return projectService.findById(id);
    }

    @PostMapping("/project")//works
    public Long createProject(@Validated @RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/project/{id}")//works
    public void updateProject(@RequestBody Project project, @PathVariable Long id) {
        projectService.updateProject(project, id);
    }

    @DeleteMapping("/project/{id}")//works
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
