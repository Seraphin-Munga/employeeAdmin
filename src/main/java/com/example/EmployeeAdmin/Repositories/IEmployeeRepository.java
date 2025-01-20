package com.example.EmployeeAdmin.Repositories;

import com.example.EmployeeAdmin.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Optional <Employee> findByEmail(String email);
    Optional <Employee> findById(int id);
}
