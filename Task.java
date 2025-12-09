package com.taskmaster.model;

import com.taskmaster.enums.Priority;

public class Task extends BaseTask {

    public Task(int id, String title, String description, Priority priority) {
        super(id, title, description, priority);
    }
}