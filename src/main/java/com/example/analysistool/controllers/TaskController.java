package com.example.analysistool.controllers;

import com.example.analysistool.models.Task;
import com.example.analysistool.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        task.setEntryTime(LocalDateTime.now());
        taskRepository.save(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/getTasks/{projectId}")
    public ResponseEntity<List<Task>> getTasks(@PathVariable long projectId) {
        List<Task> tasks = taskRepository.getAllByProjectId(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
