package com.mitocode.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	private String id;
    private String title;
    private String description;
    private TaskType type;
    private LocalDate createdOn;
    private Set<String> tags = new HashSet<>();
    
    public Task(String id, String title, TaskType type) {
        this.id = id;
        this.title = title;
        this.description = title;
        this.type = type;
        this.createdOn = LocalDate.now();
    }

    public Task(String title, TaskType type) {
        this(title, title, type, LocalDate.now());
    }

    public Task(String title, TaskType type, LocalDate createdOn) {
        this(title, title, type, createdOn);
    }

    public Task(String title, String description, TaskType type, LocalDate createdOn) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.type = type;
        this.createdOn = createdOn;
    }
    
    public Task addTag(String tag) {
        this.tags.add(tag);
        return this;
    }
    
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                '}';
    }

    
}
