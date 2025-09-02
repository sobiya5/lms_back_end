package com.sutherland.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sutherland.lms.enums.LeaveStatus;
import com.sutherland.lms.enums.LeaveType;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_seq")
    @SequenceGenerator(name = "leave_seq", sequenceName = "LEAVE_SEQ", allocationSize = 1)
    @com.fasterxml.jackson.annotation.JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Employee employee;

    @Column(name = "manager_id", nullable = false)
    private String managerId;

    private LocalDate fromDate;
    private LocalDate toDate;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private int numberOfDays;

    private LocalDate dateApplied;

    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    private String remarks;

    public LeaveRequest() {}

    @PrePersist
    public void onCreate() {
        this.dateApplied = LocalDate.now();
        this.leaveStatus = LeaveStatus.APPLIED;
        if (fromDate != null && toDate != null) {
            this.numberOfDays = (int) (toDate.toEpochDay() - fromDate.toEpochDay() + 1);
        }
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public String getManagerId() { return managerId; }
    public void setManagerId(String managerId) { this.managerId = managerId; }

    public LocalDate getFromDate() { return fromDate; }
    public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }

    public LocalDate getToDate() { return toDate; }
    public void setToDate(LocalDate toDate) { this.toDate = toDate; }

    public LeaveType getLeaveType() { return leaveType; }
    public void setLeaveType(LeaveType leaveType) { this.leaveType = leaveType; }

    public int getNumberOfDays() { return numberOfDays; }
    public void setNumberOfDays(int numberOfDays) { this.numberOfDays = numberOfDays; }

    public LocalDate getDateApplied() { return dateApplied; }
    public void setDateApplied(LocalDate dateApplied) { this.dateApplied = dateApplied; }

    public LeaveStatus getLeaveStatus() { return leaveStatus; }
    public void setLeaveStatus(LeaveStatus leaveStatus) { this.leaveStatus = leaveStatus; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
