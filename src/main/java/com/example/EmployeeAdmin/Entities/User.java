package com.example.EmployeeAdmin.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Email(message = "Email should be valid")
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private  String name;
    @Column(nullable = true)
    private String token;
    @Column(nullable = false)
    public Boolean isActivated;


    public User() { }

    public User(String password, String email, String phone, String name, String token, boolean isActivated) {
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.token = token;
        this.isActivated = isActivated;
    }

    public Boolean getIsActivated() {
        return isActivated;
    }

    public void setActivated(Boolean activated) {
        this.isActivated = activated ;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
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
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
