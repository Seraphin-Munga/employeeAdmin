package com.example.EmployeeAdmin.Repositories;

import com.example.EmployeeAdmin.Entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, Long> {
}
