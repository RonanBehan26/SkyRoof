package com.intrasoft.skyroof.controllers;

import com.intrasoft.skyroof.entities.Task;
import com.intrasoft.skyroof.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")//works
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/task/{id}")//works
    public Task getTask(@PathVariable("id") Long id) {
        return taskService.findById(id);
    }

    //status-works
    @GetMapping("/tasks/{status}")
    public List<Task> getStatus(@PathVariable("status") String status) {
        return taskService.findByStatus(status);
    }

    @PostMapping("/task")//works
    public Long createTask(@Validated @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/task/{id}")//works
    public void updateTask(@RequestBody Task task, @PathVariable Long id) {
        taskService.updateTask(task, id);
    }

    @DeleteMapping("/task/{id}")//works
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
