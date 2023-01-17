package com.example.analysistool.service;

import com.example.analysistool.models.Task;
import com.example.analysistool.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void createTask(Task task) {
        task.setEntryTime(LocalDateTime.now());
        taskRepository.save(task);
    }

    public List<Task> getAllTasksByProjectId(long projectId) {
        return taskRepository.getAllByProjectId(projectId);
    }
}
