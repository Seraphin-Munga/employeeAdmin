package com.example.EmployeeAdmin.Repositories;


import com.example.EmployeeAdmin.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByEmployeeId(Long employeeId);
}