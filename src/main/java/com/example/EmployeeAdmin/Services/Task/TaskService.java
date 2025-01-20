package com.example.EmployeeAdmin.Services.Task;

import com.example.EmployeeAdmin.Entities.Employee;
import com.example.EmployeeAdmin.Entities.Task;
import com.example.EmployeeAdmin.Repositories.IEmployeeRepository;
import com.example.EmployeeAdmin.Repositories.ITaskRepository;
import com.example.EmployeeAdmin.Shared.TaskDto.TaskDto;
import com.example.EmployeeAdmin.Shared.TaskDto.TaskReturnDtos;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ModelMapper modelMapper;

    private  final ITaskRepository taskRepository;
    private  final IEmployeeRepository employeeRepository;

    @Autowired
    public TaskService(ITaskRepository taskRepository, IEmployeeRepository employeeRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<List<TaskReturnDtos>> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskReturnDtos> TaskReturnDtos = tasks.stream()
                .map(task -> modelMapper.map(task, TaskReturnDtos.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(TaskReturnDtos);
    }


    @Override
    public ResponseEntity<TaskDto> addTask(TaskDto task) {

        Employee employee = employeeRepository.findById(task.getassigned_to()).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDeadline(task.getDeadline().toString());
        newTask.setDescription(task.getDescription());
        newTask.setStatus(task.getStatus());
        newTask.setEmployee(employee);
        newTask.setCreated_at(timestamp.toString());
        taskRepository.save(newTask);

        return ResponseEntity.ok(task);
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(Long id, TaskDto task) {

        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));

        Employee employee = employeeRepository.findById(task.getassigned_to()).orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        existingTask.setTitle(task.getTitle());
        existingTask.setDeadline(task.getDeadline().toString());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setEmployee(employee);

        taskRepository.save(existingTask);

        return ResponseEntity.ok(task);

    }

    @Override
    public ResponseEntity<List<TaskReturnDtos>> findAllByEmployeeId(Long employeeId) {
        List<Task> tasks = taskRepository.findAllByEmployeeId(employeeId);
        List<TaskReturnDtos> TaskReturnDtos = tasks.stream()
                .map(task -> modelMapper.map(task, TaskReturnDtos.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(TaskReturnDtos);
    }
}
