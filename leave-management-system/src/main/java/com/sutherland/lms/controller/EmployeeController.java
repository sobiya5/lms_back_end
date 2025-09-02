package com.sutherland.lms.controller;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3002") // allow requests from frontend
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Add employee with generated empId
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setEmpId(generateEmpId(employee.getFirstName(), employee.getLastName()));
        return service.addEmployee(employee);
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return service.getEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Get all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // Login route
    @PostMapping("/login")
    public Employee login(@RequestBody Map<String, String> loginData) {
        String empId = loginData.get("empId");
        String email = loginData.get("email");

        return service.getEmployeeById(empId)
                .filter(emp -> emp.getEmail().equalsIgnoreCase(email))
                .orElseThrow(() -> new RuntimeException("Invalid EmpID or Email"));
    }

    // Generate employee ID
    private String generateEmpId(String firstName, String lastName) {
        String companyPrefix = "SUTH";
        String yearJoined = "25"; // assuming 2025
        String serialCode = String.format("%03d", (int)(Math.random() * 1000)); // random 3-digit
        return companyPrefix + yearJoined + serialCode;
    }
}
