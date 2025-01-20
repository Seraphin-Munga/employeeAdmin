package com.example.EmployeeAdmin.Services.Employee;
import com.example.EmployeeAdmin.Entities.Employee;
import com.example.EmployeeAdmin.Shared.Employee.EmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {

    public ResponseEntity<EmployeeDTO> addEmployee(EmployeeDTO employee);
    public ResponseEntity<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employee);
    public ResponseEntity<List<Employee>> getAllEmployees();
    public  ResponseEntity<EmployeeDTO>  toggleEmployeeActivation(Long id);
}
