package com.example.EmployeeAdmin.Entities;

import com.example.EmployeeAdmin.Core.Enums.DepartmentEnum;
import com.example.EmployeeAdmin.Core.Enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee extends User {

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    public RoleEnum role;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    public  DepartmentEnum department;
    @Column(nullable = false)
    public  String address;

    @OneToOne
    public User user;

    public Employee() { }

    public Employee(RoleEnum role, DepartmentEnum department, String address, User user) {
        this.role = role;
        this.department = department;
        this.address = address;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public DepartmentEnum getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", role=" + role +
                ", department=" + department +
                ", address='" + address + '\'' +
                ", isActivated=" + isActivated +
                '}';
    }

}
