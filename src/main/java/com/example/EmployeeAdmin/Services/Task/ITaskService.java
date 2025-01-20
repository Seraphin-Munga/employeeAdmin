package com.example.EmployeeAdmin.Services.Task;


import com.example.EmployeeAdmin.Entities.Task;
import com.example.EmployeeAdmin.Shared.TaskDto.TaskDto;
import com.example.EmployeeAdmin.Shared.TaskDto.TaskReturnDtos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITaskService {

        public ResponseEntity<List<TaskReturnDtos>> getAllTasks();
        public ResponseEntity<TaskDto> addTask(TaskDto task);
        public ResponseEntity<TaskDto> updateTask(Long id, TaskDto task);
        public ResponseEntity<List<TaskReturnDtos>> findAllByEmployeeId(Long employeeId);

}
