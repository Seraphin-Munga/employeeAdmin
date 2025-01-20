package com.example.EmployeeAdmin.Controllers;


import com.example.EmployeeAdmin.Core.Models.LoginModel;
import com.example.EmployeeAdmin.Core.Models.LoginRetrieval;
import com.example.EmployeeAdmin.Services.User.UserService;
import com.example.EmployeeAdmin.Shared.UserDto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/")
public class UserController {

         private  final UserService userService;

            public UserController(UserService userService){
                this.userService = userService;
            }

            @PostMapping("/users")
            public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
                return userService.createUser(userDto);
            }

            @PostMapping("/users/login")
            public ResponseEntity<LoginRetrieval> login(@Valid @RequestBody LoginModel loginModel) {
                return userService.login(loginModel);
            }
}
