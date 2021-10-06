package com.intrasoft.skyroof.repositories;

import com.intrasoft.skyroof.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
