package com.intrasoft.skyroof.repositories;

import com.intrasoft.skyroof.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(String status);
}
