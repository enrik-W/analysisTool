package com.example.analysistool.controllers;

import com.example.analysistool.models.Project;
import com.example.analysistool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping("/all")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping("/add")
    public void addProject(@RequestBody Project project) {
        projectRepository.save(project);
    }
}