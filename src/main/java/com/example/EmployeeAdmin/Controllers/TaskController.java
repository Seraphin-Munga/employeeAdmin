package com.example.EmployeeAdmin.Controllers;


import com.example.EmployeeAdmin.Entities.Task;
import com.example.EmployeeAdmin.Services.Task.TaskService;
import com.example.EmployeeAdmin.Shared.TaskDto.TaskDto;
import com.example.EmployeeAdmin.Shared.TaskDto.TaskReturnDtos;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/")
public class TaskController {

           private  final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskReturnDtos>> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> addTask(@Valid @RequestBody TaskDto task) {
        return taskService.addTask(task);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> updateTask(Long id, @Valid @RequestBody TaskDto task) {
        return taskService.updateTask(id, task);
    }

    @GetMapping("/tasks/employee/{employeeId}")
    public ResponseEntity<List<TaskReturnDtos>> findAllByEmployeeId(@PathVariable Long employeeId) {
        return taskService.findAllByEmployeeId(employeeId);
    }

}
