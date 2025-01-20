package com.example.EmployeeAdmin.Services.User;

import com.example.EmployeeAdmin.Core.Models.LoginModel;
import com.example.EmployeeAdmin.Core.Models.LoginRetrieval;
import com.example.EmployeeAdmin.Entities.User;
import com.example.EmployeeAdmin.Repositories.IUserRepository;
import com.example.EmployeeAdmin.Shared.UserDto.UserDto;
import com.example.EmployeeAdmin.Shared.Utilities.Jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService  implements  IUserService {

    private  final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        User newUser = new User();

        Optional<User> existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (userRepository.findByPhone(userDto.getPhone()).isPresent()) {
            throw new IllegalArgumentException("Phone number already exists");
        }

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPhone(userDto.getPhone());
        newUser.setPassword(encodedPassword);
        newUser.setActivated(true);
        User savedUser = userRepository.save(newUser);

        return ResponseEntity.ok(userDto);

    }

    @Override
    public ResponseEntity<LoginRetrieval> login(LoginModel loginModel) {

        User user =  userRepository.findByEmail(loginModel.getEmail()).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (!user.getIsActivated()) {
            throw new IllegalArgumentException("User is not activated");
        }

        Optional<User> existingUser =  userRepository.findById((long) user.getId());

        User updateUserToken = existingUser.get();

        String token = JwtUtils.generateToken(user.getName());

        updateUserToken.setToken(token);

        userRepository.save(updateUserToken);

        if (passwordEncoder.matches(loginModel.getPassword(), user.getPassword())) {
            return ResponseEntity.ok(new LoginRetrieval(user.getEmail(), user.getPassword(), user.getName(), token));
        }else {
            throw new IllegalArgumentException("Invalid password or email");
        }
    }
}
