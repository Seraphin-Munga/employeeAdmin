package com.example.EmployeeAdmin.Entities;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee; // Relationship with Employee

    @Column(name = "clock_in")
    private Timestamp clockIn;

    @Column(name = "clock_out")
    private Timestamp clockOut;

    @Column(name = "work_date", nullable = false)
    private Date workDate;

    public Attendance() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Timestamp getClockIn() { return clockIn; }
    public void setClockIn(Timestamp clockIn) { this.clockIn = clockIn; }

    public Timestamp getClockOut() { return clockOut; }
    public void setClockOut(Timestamp clockOut) { this.clockOut = clockOut; }

    public Date getWorkDate() { return workDate; }
    public void setWorkDate(Date workDate) { this.workDate = workDate; }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", employee=" + employee +
                ", clockIn=" + clockIn +
                ", clockOut=" + clockOut +
                ", workDate=" + workDate +
                '}';
    }
}
