package com.intrasoft.skyroof.servicesImpl;

import com.intrasoft.skyroof.entities.Project;
import com.intrasoft.skyroof.repositories.ProjectRepository;
import com.intrasoft.skyroof.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()){
            return project.get();
        }
        return null;
    }

    @Override
    public Long createProject(Project project) {
        return projectRepository.save(project).getId();
    }

    @Override
    public void updateProject(Project project, Long id) {
        Project projectFromDb = projectRepository.findById(id).get();
        projectFromDb.setTitle(project.getTitle());
        projectFromDb.setDescription(project.getDescription());
        projectFromDb.setCreation_date(project.getCreation_date());
        projectRepository.save(projectFromDb);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
