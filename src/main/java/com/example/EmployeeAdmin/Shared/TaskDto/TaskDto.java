package com.example.EmployeeAdmin.Shared.TaskDto;

import com.example.EmployeeAdmin.Core.Enums.Status;
import jakarta.validation.constraints.NotNull;

import java.security.Timestamp;
import java.time.LocalDateTime;

public class TaskDto {

    @NotNull
    public String title;
    @NotNull
    public String description;
    @NotNull
    public LocalDateTime deadline;
    @NotNull
    public Status status;
    @NotNull
    public int assigned_to;

    public TaskDto() {
    }

    public TaskDto(String title, String description, LocalDateTime deadline, Status status, int assigned_to) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.assigned_to = assigned_to;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public  int getassigned_to() {
        return assigned_to;
    }

    public void setassigned_to(int assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Task{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", status=" + status +

                '}';
    }
}
