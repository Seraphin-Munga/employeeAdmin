package com.example.EmployeeAdmin.Controllers;

import com.example.EmployeeAdmin.Core.Models.LoginModel;
import com.example.EmployeeAdmin.Core.Models.LoginRetrieval;
import com.example.EmployeeAdmin.Entities.Employee;
import com.example.EmployeeAdmin.Services.Employee.EmployeeService;
import com.example.EmployeeAdmin.Shared.Employee.EmployeeDTO;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/")
public class EmployeeController {

       private  final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService){
            this.employeeService = employeeService;
        }

         @GetMapping("/employees")
         public ResponseEntity<List<Employee>> getAllEmployees() {
             return employeeService.getAllEmployees();
         }

         @PostMapping("/employees")
         public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody  EmployeeDTO employee) {
             return employeeService.addEmployee(employee);
         }

         @PutMapping("/employees/{id}")
         public ResponseEntity<EmployeeDTO> updateEmployee(Long id, @Valid @RequestBody EmployeeDTO employee) {
                return employeeService.updateEmployee(id, employee);
         }


        @PostMapping("/employees/toggleEmployeeActivation/{id}")
        public ResponseEntity<EmployeeDTO> toggleEmployeeActivation(Long id) {
                return employeeService.toggleEmployeeActivation(id);
        }

}
