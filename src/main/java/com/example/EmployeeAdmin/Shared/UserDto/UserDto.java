package com.example.EmployeeAdmin.Shared.UserDto;

import com.example.EmployeeAdmin.Entities.User;
import jakarta.validation.constraints.*;

public class UserDto {

    @NotNull
    @Size(min = 6, max = 8, message = "Password should be at least 6 characters")
    @Pattern(
            regexp = "^[A-Z][!@#$%^&*(),.?\":{}|<>][A-Za-z\\d!@#$%^&*(),.?\":{}|<>]*$",
            message = "Password must start with a capital letter followed by a special character"
    )
    private String password;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Size(min = 10, max = 14, message = "Phone number should be 10 digits")
    private String phone;

    @NotNull
    private String name;

    public UserDto() { }

    public UserDto(String password, String email, String phone, String name) {
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public UserDto(User savedUser) {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
