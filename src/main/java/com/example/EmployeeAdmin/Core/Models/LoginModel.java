package com.example.EmployeeAdmin.Core.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginModel {

    @NotBlank(message = "Password is mandatory")
    @Email(message = "Email should be valid")
    private String  email;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 8, message = "Password should be at least 6 characters")
    @Pattern(
            regexp = "^[A-Z][!@#$%^&*(),.?\":{}|<>][A-Za-z\\d!@#$%^&*(),.?\":{}|<>]*$",
            message = "Password must start with a capital letter followed by a special character"
    )
    private String  password;

    public LoginModel() { }

    public LoginModel(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
