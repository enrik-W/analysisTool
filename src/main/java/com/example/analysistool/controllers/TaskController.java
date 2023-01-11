package com.example.analysistool.controllers;

import com.example.analysistool.models.Task;
import com.example.analysistool.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/add")
    public void addTask(@RequestBody Task task) {
        task.setEntryTime(LocalDateTime.now());
        taskRepository.save(task);
    }

    @RequestMapping("/getTasks/{projectId}")
    public List<Task> getTasks(@PathVariable long projectId) {
        return taskRepository.getAllByProjectId(projectId);
    }
}
