package com.example.EmployeeAdmin.Shared.TaskDto;

import com.example.EmployeeAdmin.Core.Enums.Status;
import com.example.EmployeeAdmin.Entities.Employee;
import jakarta.persistence.*;

public class TaskReturnDtos {

    public  int id;

    public  String title;

    public  String description;

    public String deadline;

    public Status status;


    public  String created_at;



    public TaskReturnDtos() { }

    public TaskReturnDtos(String title, String description, String deadline, Status status, String created_at) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }



    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", status=" + status +
                ", created_at='" + created_at + '\'' +
                '}';
    }

}
