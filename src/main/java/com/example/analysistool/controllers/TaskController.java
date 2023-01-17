package com.example.analysistool.controllers;

import com.example.analysistool.models.Task;
import com.example.analysistool.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        taskService.createTask(task);
        return new ResponseEntity<>("Task created", HttpStatus.CREATED);
    }

    @GetMapping("/getTasks/{projectId}")
    public ResponseEntity<List<Task>> getTasks(@PathVariable long projectId) {
        List<Task> tasks = taskService.getAllTasksByProjectId(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
