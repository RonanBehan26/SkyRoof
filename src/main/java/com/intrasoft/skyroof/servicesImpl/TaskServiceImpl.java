package com.intrasoft.skyroof.servicesImpl;

import com.intrasoft.skyroof.entities.Task;
import com.intrasoft.skyroof.repositories.TaskRepository;
import com.intrasoft.skyroof.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return task.get();
        }
        return null;
    }

    @Override
    public Long createTask(Task task) {
        return taskRepository.save(task).getId();
    }

    @Override
    public void updateTask(Task task, Long id) {
        Task taskFromDb = taskRepository.findById(id).get();
        taskFromDb.setTitle(task.getTitle());
        taskFromDb.setStatus(task.getStatus());
        taskFromDb.setCompleted_date(task.getCompleted_date());
        taskFromDb.setCreation_date(task.getCreation_date());
        taskFromDb.setDescription(task.getDescription());
        taskFromDb.setStart_date(task.getStart_date());
        taskRepository.save(taskFromDb);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
