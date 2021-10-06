package com.intrasoft.skyroof.services;

import com.intrasoft.skyroof.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    List<Project> findAll();

    Project findById(Long id);

    Long createProject(Project project);

    void updateProject(Project project, Long id);

    void deleteProject(Long id);
}
