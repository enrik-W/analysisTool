package com.example.analysistool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    private long id;
    private String name;
}
