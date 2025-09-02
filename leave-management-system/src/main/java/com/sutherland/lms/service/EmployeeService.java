package com.sutherland.lms.service;

import java.util.List;
import java.util.Optional;

import com.sutherland.lms.entity.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Optional<Employee> getEmployeeById(String empId);
    List<Employee> getAllEmployees();
}
