package com.intrasoft.skyroof.services;

import com.intrasoft.skyroof.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<Task> findAll();

    Task findById(Long id);

    Long createTask(Task task);

    void updateTask(Task task, Long id);

    void deleteTask(Long id);

    List<Task> findByStatus(String status);
}
