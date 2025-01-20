package com.example.EmployeeAdmin.Repositories;

import com.example.EmployeeAdmin.Entities.Employee;
import com.example.EmployeeAdmin.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.phone =:phone")
    Optional<User> findByPhone(@Param("phone") String phone);

    @Query("SELECT u FROM User u WHERE u.token =:token")
    Optional<User> findByToken(@Param("token") String token);
}
