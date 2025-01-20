package com.example.EmployeeAdmin.Entities;

import com.example.EmployeeAdmin.Core.Enums.Status;
import jakarta.persistence.*;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public  int id;
    @Column(nullable = false)
    public  String title;
    @Column(nullable = false)
    public  String description;
    @Column(nullable = false)
    public String deadline;
    @Column(nullable = false)
    public Status status;

    @Column(nullable = false)
    public  String created_at;

    @ManyToOne
    @JoinColumn(name = "assigned_to", nullable = false)
    public  Employee employee;

    public Task() { }

    public Task(String title, String description, String deadline, Status status, String created_at, Employee employee) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.created_at = created_at;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
                ", employee=" + employee +
                '}';
    }

}
