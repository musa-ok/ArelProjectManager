package com.taskmaster.model;

import com.taskmaster.enums.Priority;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimedTask extends Task {
    
    private LocalDateTime deadline;

    public TimedTask(int id, String title, String description, Priority priority, LocalDateTime deadline) {
        super(id, title, description, priority);
        this.deadline = deadline;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return super.toString() + " | Son Tarih: " + deadline.format(formatter);
    }
}