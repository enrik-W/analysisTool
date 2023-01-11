package com.example.analysistool.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn
    private Project project;
    private String taskDescription;
    private boolean performed;
    private boolean reviewed;
    @ManyToOne
    @JoinColumn
    private Users analyst;
    @ManyToOne
    @JoinColumn
    private Users reviewer;
    private LocalDateTime timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isPerformed() {
        return performed;
    }

    public void setPerformed(boolean performed) {
        this.performed = performed;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public Users getAnalyst() {
        return analyst;
    }

    public void setAnalyst(Users analyst) {
        this.analyst = analyst;
    }

    public Users getReviewer() {
        return reviewer;
    }

    public void setReviewer(Users reviewer) {
        this.reviewer = reviewer;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
