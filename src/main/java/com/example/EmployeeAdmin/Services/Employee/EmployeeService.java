package com.example.EmployeeAdmin.Services.Employee;

import com.example.EmployeeAdmin.Entities.Employee;
import com.example.EmployeeAdmin.Entities.User;
import com.example.EmployeeAdmin.Repositories.IEmployeeRepository;
import com.example.EmployeeAdmin.Repositories.IUserRepository;
import com.example.EmployeeAdmin.Shared.Employee.EmployeeDTO;
import com.example.EmployeeAdmin.Shared.Utilities.Jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    public final IEmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private  final IUserRepository userRepository;;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository, IUserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public ResponseEntity<EmployeeDTO> addEmployee(EmployeeDTO employeeDTO) {
        // Check if the employee already exists based on email
        Optional<Employee> existingUser = employeeRepository.findByEmail(employeeDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Create the User entity and set the password to the encoded version
        String encodedPassword = passwordEncoder.encode(employeeDTO.getPassword());
        User user = new User();
        user.setEmail(employeeDTO.getEmail());
        user.setPassword(encodedPassword);
        user.setPhone(employeeDTO.getPhone());
        user.setName(employeeDTO.getName());
        user.setActivated(true);

        // Save the user in the repository
        user = userRepository.save(user);

        // Create the Employee entity and set its properties
        Employee newEmployee = new Employee();
        newEmployee.setRole(employeeDTO.getRole());
        newEmployee.setAddress(employeeDTO.getAddress());
        newEmployee.setDepartment(employeeDTO.getDepartment());
        newEmployee.setEmail(employeeDTO.getEmail());
        newEmployee.setPhone(employeeDTO.getPhone());
        newEmployee.setName(employeeDTO.getName());
        newEmployee.setPassword(encodedPassword);
        newEmployee.setActivated(true);
        newEmployee.setUser(user); // Link the User entity to the Employee

        // Save the employee
        Employee savedEmployee = employeeRepository.save(newEmployee);

        // Return the response with the saved employee details
        return ResponseEntity.ok(employeeDTO);
    }

    @Override
    public ResponseEntity<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO) {

        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();

            // Update the Employee details
            updatedEmployee.setName(employeeDTO.getName());
            updatedEmployee.setEmail(employeeDTO.getEmail());
            updatedEmployee.setRole(employeeDTO.getRole());
            updatedEmployee.setAddress(employeeDTO.getAddress());
            updatedEmployee.setPhone(employeeDTO.getPhone());


            User user = updatedEmployee.getUser();
            user.setEmail(employeeDTO.getEmail());
            user.setPhone(employeeDTO.getPhone());
            user.setName(employeeDTO.getName());
            userRepository.save(user);

            // Save the updated Employee entity
            Employee savedEmployee = employeeRepository.save(updatedEmployee);

            // Return the response with the saved employee details
            return ResponseEntity.ok(new EmployeeDTO(savedEmployee));
        }

        return ResponseEntity.notFound().build();
    }



    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }


    @Override
    public ResponseEntity<EmployeeDTO> toggleEmployeeActivation(Long id) {

        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        boolean changeState = !existingEmployee.get().getIsActivated();

        Employee updatedEmployee = existingEmployee.get();
        User user = updatedEmployee.getUser();
        user.setActivated(changeState);
        updatedEmployee.setActivated(changeState);
        userRepository.save(user);
        Employee savedEmployee = employeeRepository.save(updatedEmployee);
        return ResponseEntity.accepted().build();

    }


}
