package com.example.EmployeeAdmin.Core.Models;

public class LoginRetrieval {


    private String phoneNumber;
    private String password;
    private  String name;
    private String token;

    public LoginRetrieval() { }

    public LoginRetrieval(String phoneNumber, String password, String name, String token) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.name = name;
        this.token = token;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override

    public String toString() {
        return "LoginRetrieval{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
