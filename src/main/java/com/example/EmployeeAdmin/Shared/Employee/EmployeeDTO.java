package com.example.EmployeeAdmin.Shared.Employee;

import com.example.EmployeeAdmin.Entities.Employee;
import com.example.EmployeeAdmin.Core.Enums.DepartmentEnum;
import com.example.EmployeeAdmin.Core.Enums.RoleEnum;
import com.example.EmployeeAdmin.Shared.UserDto.UserDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

public class EmployeeDTO extends UserDto {

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    public RoleEnum role;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    public DepartmentEnum department;

    @NotNull(message = "Address is mandatory")
    public  String address;

    public EmployeeDTO() { }

    public EmployeeDTO( RoleEnum role, DepartmentEnum department, String address) {
        this.role = role;
        this.department = department;
        this.address = address;
    }

    public EmployeeDTO(Employee savedEmployee) {
    }



    public @NotNull RoleEnum getRole() {
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
        return "EmployeeDTO{" +
                ", role=" + role +
                ", department=" + department +
                ", address='" + address + '\'' +
                '}';
    }

}
