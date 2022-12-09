package com.example.analysistool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private boolean isActive;
}
