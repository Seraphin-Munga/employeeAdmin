package com.example.EmployeeAdmin.Services.User;

import com.example.EmployeeAdmin.Core.Models.LoginModel;
import com.example.EmployeeAdmin.Core.Models.LoginRetrieval;
import com.example.EmployeeAdmin.Shared.UserDto.UserDto;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    public ResponseEntity<UserDto> createUser(UserDto userDto);
    public ResponseEntity<LoginRetrieval> login(LoginModel login);

}
